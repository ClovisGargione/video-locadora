package com.github.clovisgargione.flyway;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.github.clovisgargione.tenant.datasource.MultitenantConfiguration;

import jakarta.annotation.PostConstruct;

@Configuration
public class FlywayInitializer {


	@Autowired
	private MultitenantConfiguration datasource;
	
    @PostConstruct
    public void migrateFlyway() {
        Flyway flywayTenant1 = Flyway.configure().dataSource(datasource.getDataSourceByTenant("tenant_1")).baselineOnMigrate(true).locations("classpath:db/migrations").load();
        Flyway flywayTenant2 = Flyway.configure().dataSource(datasource.getDataSourceByTenant("tenant_2")).baselineOnMigrate(true).locations("classpath:db/migrations").load();

        flywayTenant1.migrate();

        flywayTenant2.migrate();
    }
}
