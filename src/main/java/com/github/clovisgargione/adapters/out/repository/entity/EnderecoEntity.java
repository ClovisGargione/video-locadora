package com.github.clovisgargione.adapters.out.repository.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="endereco")
public class EnderecoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	
	private String rua;
	
	private Integer numero;
	
	private String complemento;
	
	private Integer cep;

	private String bairro;

	private String cidade;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_id", referencedColumnName = "id")
	private UsuarioEntity usuario;
}
