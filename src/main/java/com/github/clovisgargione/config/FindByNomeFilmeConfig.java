package com.github.clovisgargione.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.clovisgargione.adapters.out.FindByNomeFilmeAdapter;
import com.github.clovisgargione.application.core.usecase.FindByNomeFilmeUseCase;

@Configuration
public class FindByNomeFilmeConfig {

	@Bean
	FindByNomeFilmeUseCase findByNomeFilmeUseCase(FindByNomeFilmeAdapter findByNomeFilmeAdapter) {
		return new FindByNomeFilmeUseCase(findByNomeFilmeAdapter);
	}
}
