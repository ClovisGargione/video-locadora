package com.github.clovisgargione.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.clovisgargione.adapters.out.UpdateUsuarioAdapter;
import com.github.clovisgargione.application.core.usecase.UpdateUsuarioUseCase;

@Configuration
public class UpdateUsuarioConfig {

	@Bean
	UpdateUsuarioUseCase updateUsuarioUseCase(UpdateUsuarioAdapter updateUsuarioAdapter) {
		return new UpdateUsuarioUseCase(updateUsuarioAdapter);
	}
}
