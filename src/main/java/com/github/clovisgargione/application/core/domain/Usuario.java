package com.github.clovisgargione.application.core.domain;

import java.util.List;

import com.github.clovisgargione.adapters.out.repository.entity.Credenciais;

public class Usuario {

	private String id;

	private String nome;

	private Credenciais credenciais;

	private List<Authority> authorities;

	private Endereco endereco;

	public Usuario() {
		super();
	}

	public Usuario(String id, String nome, Credenciais credenciais, List<Authority> authorities, Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.credenciais = credenciais;
		this.authorities = authorities;
		this.endereco = endereco;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Credenciais getCredenciais() {
		return credenciais;
	}

	public void setCredenciais(Credenciais credenciais) {
		this.credenciais = credenciais;
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
