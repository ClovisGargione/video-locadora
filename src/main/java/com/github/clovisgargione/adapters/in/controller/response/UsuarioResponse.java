package com.github.clovisgargione.adapters.in.controller.response;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponse {

	private String id;

	@NotBlank
	private String nome;

	private CredenciaisResponse credenciais;

	private List<AuthorityResponse> authorities;

	private EnderecoResponse endereco;
}
