package com.github.clovisgargione.application.core.domain;

import java.util.Date;

public class Credenciais {

private String email;
	
	private String senha;
	
    private boolean habilitado;

    private Date dataUltimaRedefinicaoDeSenha;

    private boolean contaNaoExpirada;

    private boolean contaNaoBloqueada;

    private boolean credencialNaoExpirada;

	public Credenciais() {
		super();
	}

	public Credenciais(String email, String senha, boolean habilitado, Date dataUltimaRedefinicaoDeSenha,
			boolean contaNaoExpirada, boolean contaNaoBloqueada, boolean credencialNaoExpirada) {
		super();
		this.email = email;
		this.senha = senha;
		this.habilitado = habilitado;
		this.dataUltimaRedefinicaoDeSenha = dataUltimaRedefinicaoDeSenha;
		this.contaNaoExpirada = contaNaoExpirada;
		this.contaNaoBloqueada = contaNaoBloqueada;
		this.credencialNaoExpirada = credencialNaoExpirada;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	public Date getDataUltimaRedefinicaoDeSenha() {
		return dataUltimaRedefinicaoDeSenha;
	}

	public void setDataUltimaRedefinicaoDeSenha(Date dataUltimaRedefinicaoDeSenha) {
		this.dataUltimaRedefinicaoDeSenha = dataUltimaRedefinicaoDeSenha;
	}

	public boolean isContaNaoExpirada() {
		return contaNaoExpirada;
	}

	public void setContaNaoExpirada(boolean contaNaoExpirada) {
		this.contaNaoExpirada = contaNaoExpirada;
	}

	public boolean isContaNaoBloqueada() {
		return contaNaoBloqueada;
	}

	public void setContaNaoBloqueada(boolean contaNaoBloqueada) {
		this.contaNaoBloqueada = contaNaoBloqueada;
	}

	public boolean isCredencialNaoExpirada() {
		return credencialNaoExpirada;
	}

	public void setCredencialNaoExpirada(boolean credencialNaoExpirada) {
		this.credencialNaoExpirada = credencialNaoExpirada;
	}
}
