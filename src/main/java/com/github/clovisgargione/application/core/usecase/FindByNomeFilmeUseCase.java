package com.github.clovisgargione.application.core.usecase;

import java.util.List;

import com.github.clovisgargione.application.core.domain.Filme;
import com.github.clovisgargione.application.ports.in.FindByNomeFilmeInputPort;
import com.github.clovisgargione.application.ports.out.FindByNomeFilmeOutputPort;

public class FindByNomeFilmeUseCase implements FindByNomeFilmeInputPort {

	private final FindByNomeFilmeOutputPort findBynomeFilmeOutputPort;

	public FindByNomeFilmeUseCase(FindByNomeFilmeOutputPort findBynomeFilmeOutputPort) {
		super();
		this.findBynomeFilmeOutputPort = findBynomeFilmeOutputPort;
	}

	@Override
	public List<Filme> filmes(String nome) {
		List<Filme> filmes = this.findBynomeFilmeOutputPort.filmes(nome);
		return filmes;
	}

}
