package com.github.clovisgargione.adapters.in.controller.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CredenciaisResponse {

	@NotBlank
	private String email;

	@JsonIgnore
	@NotBlank
	private String senha;

	@NotNull
	private boolean habilitado;

	@NotNull
	private Date dataUltimaRedefinicaoDeSenha;

	@NotNull
	private boolean contaNaoExpirada;

	@NotNull
	private boolean contaNaoBloqueada;

	@NotNull
	private boolean credencialNaoExpirada;
}
