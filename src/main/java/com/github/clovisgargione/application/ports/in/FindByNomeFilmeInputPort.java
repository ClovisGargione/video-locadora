package com.github.clovisgargione.application.ports.in;

import java.util.List;

import com.github.clovisgargione.application.core.domain.Filme;

public interface FindByNomeFilmeInputPort {

	List<Filme> filmes(String nome);
}
