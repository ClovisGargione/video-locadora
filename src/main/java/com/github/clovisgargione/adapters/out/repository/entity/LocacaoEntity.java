package com.github.clovisgargione.adapters.out.repository.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "locacao")
public class LocacaoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID	)
	private String id;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private UsuarioEntity usuario;
	
	@ManyToOne
	@JoinColumn(name = "filme_id")
	private FilmeEntity filme;
	
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime dataLocacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime dataDevolucao;
	
	private Double valorLocacao;
}
