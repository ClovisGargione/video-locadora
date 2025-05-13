package com.github.clovisgargione.application.core.usecase;

import com.github.clovisgargione.application.core.domain.Filme;
import com.github.clovisgargione.application.ports.in.InsertFilmeInputPort;
import com.github.clovisgargione.application.ports.out.InsertFilmeOutputPort;

public class InsertFilmeUseCase implements InsertFilmeInputPort {

	private final InsertFilmeOutputPort insertFilmeOutputPort;
	
	public InsertFilmeUseCase(InsertFilmeOutputPort insertFilmeOutputPort) {
		super();
		this.insertFilmeOutputPort = insertFilmeOutputPort;
	}

	@Override
	public Filme insert(Filme filme) {
		Filme novoFilme = this.insertFilmeOutputPort.insert(filme);
		return novoFilme;
	}

}
