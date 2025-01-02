package com.github.clovisgargione.adapters.out.repository.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class Credenciais {

	@NotNull
	private String email;
	
	@NotNull
	@JsonIgnore
	private String senha;
	
	@NotNull
    private boolean habilitado;
    
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date dataUltimaRedefinicaoDeSenha;
    
    @NotNull
    private boolean contaNaoExpirada;
    
    @NotNull
    private boolean contaNaoBloqueada;
    
    @NotNull
    private boolean credencialNaoExpirada;
}
