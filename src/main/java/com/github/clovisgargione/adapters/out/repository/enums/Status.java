package com.github.clovisgargione.adapters.out.repository.enums;

import jakarta.persistence.AttributeConverter;
import java.util.stream.Stream;
import jakarta.persistence.Converter;

public enum Status {
	DISPONIVEL("Disponível"), ALUGADO("Alugado"), RESERVADO("Reservado");

	private final String valor;
	
	Status(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}
	
	@Converter(autoApply = true)
	public static class StatusConverter implements AttributeConverter<Status, String> {
	 
	    @Override
	    public String convertToDatabaseColumn(Status status) {
	        if (status == null) {
	            return null;
	        }
	        return status.getValor();
	    }

	    @Override
	    public Status convertToEntityAttribute(String valor) {
	        if (valor == null) {
	            return null;
	        }

	        return Stream.of(Status.values())
	          .filter(c -> c.getValor().equals(valor))
	          .findFirst()
	          .orElseThrow(IllegalArgumentException::new);
	    }
	}
}
