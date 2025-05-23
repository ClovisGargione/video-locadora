package com.github.clovisgargione.adapters.in.controller.request;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioRequest {

	private String id;
	
	@NotBlank
	private String nome;

	private CredenciaisRequest credenciais;

	private List<AuthorityRequest> authorities;

	private EnderecoRequest endereco;
	
	public List<GrantedAuthority> mapToGrantedAuthorities() {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName().name()))
                .collect(Collectors.toList());
    }
}
