package com.github.clovisgargione.application.core.domain;

import java.time.LocalDateTime;

public class Reserva {

	private String id;
	
	private Filme filme;
	
	private Usuario usuario;
	
	private LocalDateTime data;

	public Reserva(String id, Filme filme, Usuario usuario, LocalDateTime data) {
		super();
		this.id = id;
		this.filme = filme;
		this.usuario = usuario;
		this.data = data;
	}

	public Reserva() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
}
