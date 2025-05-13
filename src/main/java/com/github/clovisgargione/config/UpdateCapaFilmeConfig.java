package com.github.clovisgargione.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.clovisgargione.adapters.out.UpdateCapaFilmeAdapter;
import com.github.clovisgargione.application.core.usecase.UpdateCapaFilmeUseCase;

@Configuration
public class UpdateCapaFilmeConfig {

	@Bean
	UpdateCapaFilmeUseCase updateCapaFilmeUseCase(UpdateCapaFilmeAdapter updateCapaFilmeAdapter) {
		return new UpdateCapaFilmeUseCase(updateCapaFilmeAdapter);
	}
}
