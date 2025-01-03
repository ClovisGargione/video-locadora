package com.github.clovisgargione.adapters.in.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoRequest {

	@NotBlank
	private String rua;

	@NotNull
	private Integer numero;

	@NotBlank
	private String complemento;
	
	@NotBlank
	private String bairro;
	
	@NotBlank
	private String cidade;

	@NotBlank
	private Integer cep;
}
