package com.github.clovisgargione.application.ports.in;

import java.util.List;

import com.github.clovisgargione.application.core.domain.Filme;

public interface UpdateCapaFilmeInputPort {

	List<Filme> setCapa(String nome, String capa);
	
}
