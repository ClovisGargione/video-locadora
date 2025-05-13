package com.github.clovisgargione.application.core.domain;

import java.time.LocalDateTime;

public class Locacao {

	private String id;
	
	private Usuario usuario;
	
	private Filme filme;
	
	private LocalDateTime dataLocacao;
	
	private LocalDateTime dataDevolucao;
	
	private Double valorLocacao;

	public Locacao() {
		super();
	}

	public Locacao(String id, Usuario usuario, Filme filme, LocalDateTime dataLocacao, LocalDateTime dataDevolucao,
			Double valorLocacao) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.filme = filme;
		this.dataLocacao = dataLocacao;
		this.dataDevolucao = dataDevolucao;
		this.valorLocacao = valorLocacao;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public LocalDateTime getDataLocacao() {
		return dataLocacao;
	}

	public void setDataLocacao(LocalDateTime dataLocacao) {
		this.dataLocacao = dataLocacao;
	}

	public LocalDateTime getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDateTime dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public Double getValorLocacao() {
		return valorLocacao;
	}

	public void setValorLocacao(Double valorLocacao) {
		this.valorLocacao = valorLocacao;
	}
}
