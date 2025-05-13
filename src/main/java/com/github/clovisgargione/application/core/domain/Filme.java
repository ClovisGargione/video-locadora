package com.github.clovisgargione.application.core.domain;

import com.github.clovisgargione.application.core.enums.Status;
import com.github.clovisgargione.application.core.enums.Tipo;

public class Filme {

	private String id;
	
	private String nome;
	
	private Tipo tipo; 
	
	private String capa;
	
	private Double valor;
	
	private Status status;

	public Filme() {
		super();
	}

	public Filme(String id, String nome, Tipo tipo, String capa, Double valor, Status status) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.capa = capa;
		this.valor = valor;
		this.status = status;
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
	
	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String getCapa() {
		return capa;
	}

	public void setCapa(String capa) {
		this.capa = capa;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
