package com.github.clovisgargione.application.core.usecase;

import java.util.List;

import com.github.clovisgargione.application.core.domain.Filme;
import com.github.clovisgargione.application.ports.in.UpdateCapaFilmeInputPort;
import com.github.clovisgargione.application.ports.out.UpdateCapaFilmeOutputPort;

public class UpdateCapaFilmeUseCase implements UpdateCapaFilmeInputPort {

	private final UpdateCapaFilmeOutputPort updateCapaFilmeOutputPort;

	public UpdateCapaFilmeUseCase(UpdateCapaFilmeOutputPort updateCapaFilmeOutputPort) {
		super();
		this.updateCapaFilmeOutputPort = updateCapaFilmeOutputPort;
	}

	@Override
	public List<Filme> setCapa(String nome, String capa) {
		List<Filme> filmes = this.updateCapaFilmeOutputPort.setCapa(nome, capa);
		return filmes;
	}

}
