package com.github.clovisgargione.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.clovisgargione.adapters.out.DeleteUsuarioAdapter;
import com.github.clovisgargione.application.core.usecase.DeleteUsuarioUseCase;

@Configuration
public class DeleteUsuarioConfig {

	@Bean
	DeleteUsuarioUseCase deleteUsuarioUseCase(DeleteUsuarioAdapter deleteUsuarioAdapter) {
		return new DeleteUsuarioUseCase(deleteUsuarioAdapter);
	}
}
