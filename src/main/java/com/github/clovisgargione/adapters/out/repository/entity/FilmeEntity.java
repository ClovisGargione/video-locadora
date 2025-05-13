package com.github.clovisgargione.adapters.out.repository.entity;


import com.github.clovisgargione.adapters.out.repository.enums.Status;
import com.github.clovisgargione.adapters.out.repository.enums.Tipo;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "filme")
public class FilmeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID	)
	private String id;
	
	private String nome;
	
	private String capa;
	
	@Convert(converter = Tipo.TipoConverter.class)
	private Tipo tipo;
	
	private Double valor;
	
	@Convert(converter = Status.StatusConverter.class)
	private Status status;
}
