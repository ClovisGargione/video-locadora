package com.github.clovisgargione.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.clovisgargione.adapters.out.ListFilmeAdapter;
import com.github.clovisgargione.application.core.usecase.ListFilmeUseCase;

@Configuration
public class ListFilmeConfig {

	@Bean
	ListFilmeUseCase listFilmeUseCase(ListFilmeAdapter listFilmeAdapter) {
		return new ListFilmeUseCase(listFilmeAdapter);
	}
}
