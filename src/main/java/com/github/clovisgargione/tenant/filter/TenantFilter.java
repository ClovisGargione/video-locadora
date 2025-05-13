package com.github.clovisgargione.tenant.filter;

import java.io.IOException;
import java.util.stream.Collectors;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.github.clovisgargione.tenant.TenantContext;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

@Component
@Order(1)
public class TenantFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		String tenantName = req.getHeader("X-TenantID");
		//String body = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		TenantContext.setCurrentTenant(tenantName);

		try {
			chain.doFilter(request, response);
		} finally {
			TenantContext.setCurrentTenant("");
		}

	}

}
