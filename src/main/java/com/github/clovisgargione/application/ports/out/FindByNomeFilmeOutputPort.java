package com.github.clovisgargione.application.ports.out;

import java.util.List;

import com.github.clovisgargione.application.core.domain.Filme;

public interface FindByNomeFilmeOutputPort {

	List<Filme> filmes(String nome);
}
