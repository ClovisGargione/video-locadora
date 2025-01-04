package com.github.clovisgargione.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.clovisgargione.adapters.out.FindByUsernameAdapter;
import com.github.clovisgargione.application.core.usecase.FindByUsernameUseCase;

@Configuration
public class FindByUsernameConfig {

	@Bean
	FindByUsernameUseCase findByUsernameUseCase(FindByUsernameAdapter findByUsernameAdapter) {
		return new FindByUsernameUseCase(findByUsernameAdapter);
		
	}
}
