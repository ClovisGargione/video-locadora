package com.github.clovisgargione.application.core.usecase;

import java.util.List;

import com.github.clovisgargione.application.core.domain.Filme;
import com.github.clovisgargione.application.ports.in.ListFilmeInputPort;
import com.github.clovisgargione.application.ports.out.ListFilmeOutputPort;

public class ListFilmeUseCase implements ListFilmeInputPort {

	private final ListFilmeOutputPort listFilmeOutputPort;

	public ListFilmeUseCase(ListFilmeOutputPort listFilmeOutputPort) {
		super();
		this.listFilmeOutputPort = listFilmeOutputPort;
	}

	@Override
	public List<Filme> filmes() {
		List<Filme> filmes = this.listFilmeOutputPort.filmes();
		return filmes;
	}
}
