package com.github.clovisgargione.tenant.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.github.clovisgargione.tenant.TenantContext;

public class MultitenantDataSource extends AbstractRoutingDataSource{

	@Override
	protected Object determineCurrentLookupKey() {
		return TenantContext.getCurrentTenant();
	}

}
