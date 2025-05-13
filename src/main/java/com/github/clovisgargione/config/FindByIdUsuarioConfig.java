package com.github.clovisgargione.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.clovisgargione.adapters.out.FindByIdUsuarioAdapter;
import com.github.clovisgargione.application.core.usecase.FindByIdUsuarioUseCase;

@Configuration
public class FindByIdUsuarioConfig {

	@Bean
	FindByIdUsuarioUseCase findByIdUsuarioUseCase(FindByIdUsuarioAdapter findByIdUsuarioAdapter) {
		return new FindByIdUsuarioUseCase(findByIdUsuarioAdapter);
	}
}
