package com.github.clovisgargione.application.ports.out;

import java.util.List;

import com.github.clovisgargione.application.core.domain.Filme;

public interface UpdateCapaFilmeOutputPort {

	List<Filme> setCapa(String nome, String capa);
}
