package com.github.clovisgargione.adapters.in.controller.request;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.clovisgargione.adapters.out.repository.enums.Status;
import com.github.clovisgargione.adapters.out.repository.enums.Tipo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmeRequest {

	private String id;
	
	@NotBlank
	private String nome;
	
	@NotEmpty
	private Tipo tipo;
		
	@NotNull
	private Double valor;
	
	@NotEmpty
	private Status status;
}
