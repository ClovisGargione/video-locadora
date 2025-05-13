package com.github.clovisgargione.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.clovisgargione.adapters.out.InsertFilmeAdapter;
import com.github.clovisgargione.application.core.usecase.InsertFilmeUseCase;

@Configuration
public class InsertFilmeConfig {

	@Bean
	InsertFilmeUseCase insertFilmeUseCase(InsertFilmeAdapter insertFilmeAdapter) {
		return new InsertFilmeUseCase(insertFilmeAdapter);
	}
}
