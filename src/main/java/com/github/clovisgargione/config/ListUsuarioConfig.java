package com.github.clovisgargione.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.clovisgargione.adapters.out.ListUsuarioAdapter;
import com.github.clovisgargione.application.core.usecase.ListUsuarioUseCase;

@Configuration
public class ListUsuarioConfig {

	@Bean
	ListUsuarioUseCase listUsuarioUseCase(ListUsuarioAdapter listUsuarioAdapter) {
		return new ListUsuarioUseCase(listUsuarioAdapter);
		
	}
}
