package com.github.clovisgargione.tenant.datasource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.util.ResourceUtils;

@Configuration
public class MultitenantConfiguration {

	@Value("${defaultTenant}")
    private String defaultTenant;
	
	private Map<Object, Object> resolvedDataSources = new HashMap<>();

    @Bean
    @ConfigurationProperties(prefix = "tenants")
    DataSource dataSource() throws IOException {
    	
    	InputStream inputStreamTentant1 =  getClass().getResourceAsStream("/allTenants/tenant_1.properties");
    	File tenant1 = File.createTempFile("allTenants/tenant_1", ".properties");//new File("allTenants/tenant_1.properties");
    	FileUtils.copyInputStreamToFile(inputStreamTentant1, tenant1);
    	InputStream inputStreamTentant2 =  getClass().getResourceAsStream("/allTenants/tenant_2.properties");
    	File tenant2 = File.createTempFile("allTenants/tenant_2", ".properties");//new File("allTenants/tenant_2.properties");
    	FileUtils.copyInputStreamToFile(inputStreamTentant2, tenant2);
    	File[] files = {tenant1, tenant2};
        //File[] files = getClass().getResourceAsStream("allTenants");//ResourceUtils.getFile("file:///video-locadora/src/main/resources/allTenants").listFiles(); /*Paths.get("allTenants").toFile().listFiles();*/
        

        for (File propertyFile : files) {
            Properties tenantProperties = new Properties();
            DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();

            try {
                tenantProperties.load(new FileInputStream(propertyFile));
                String tenantId = tenantProperties.getProperty("name");

                dataSourceBuilder.driverClassName(tenantProperties.getProperty("datasource.driver-class-name"));
                dataSourceBuilder.username(tenantProperties.getProperty("datasource.username"));
                dataSourceBuilder.password(tenantProperties.getProperty("datasource.password"));
                dataSourceBuilder.url(tenantProperties.getProperty("datasource.url"));
                resolvedDataSources.put(tenantId, dataSourceBuilder.build());
            } catch (IOException exp) {
                throw new RuntimeException("Problem in tenant datasource:" + exp);
            }
        }

        AbstractRoutingDataSource dataSource = new MultitenantDataSource();
        dataSource.setDefaultTargetDataSource(resolvedDataSources.get(defaultTenant));
        dataSource.setTargetDataSources(resolvedDataSources);

        dataSource.afterPropertiesSet();
        return dataSource;
    }
    
    public DataSource getDataSourceByTenant(String tenant) {
        return (DataSource) resolvedDataSources.get(tenant);
    }
}
