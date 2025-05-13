package com.github.clovisgargione.adapters.out.repository.enums;

import java.util.stream.Stream;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

public enum Tipo {

	DUBLADO("Dublado"), LEGENDADO("Legendado");
	
	private final String valor;

	Tipo(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}
	
	@Converter(autoApply = true)
	public static class TipoConverter implements AttributeConverter<Tipo, String> {
	 
	    @Override
	    public String convertToDatabaseColumn(Tipo tipo) {
	        if (tipo == null) {
	            return null;
	        }
	        return tipo.getValor();
	    }

	    @Override
	    public Tipo convertToEntityAttribute(String valor) {
	        if (valor == null) {
	            return null;
	        }

	        return Stream.of(Tipo.values())
	          .filter(c -> c.getValor().equals(valor))
	          .findFirst()
	          .orElseThrow(IllegalArgumentException::new);
	    }
	}
}
