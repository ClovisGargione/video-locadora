package com.github.clovisgargione.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.clovisgargione.adapters.out.InsertUsuarioAdapter;
import com.github.clovisgargione.application.core.usecase.InsertUsuarioUseCase;

@Configuration
public class InsertUsuarioConfig {

	@Bean
	InsertUsuarioUseCase insertUsuarioUseCase(InsertUsuarioAdapter insertUsuarioAdapter) {
		return new InsertUsuarioUseCase(insertUsuarioAdapter);
		
	}
}
