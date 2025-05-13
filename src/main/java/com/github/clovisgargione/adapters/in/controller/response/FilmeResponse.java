package com.github.clovisgargione.adapters.in.controller.response;

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
public class FilmeResponse {

	private String id;
	
	@NotBlank
	private String nome;
	
	@NotEmpty
	private Tipo tipo;
	
	private String capa;
		
	@NotNull
	private Double valor;
	
	@NotEmpty
	private Status status;
}
