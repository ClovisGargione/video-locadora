package com.github.clovisgargione.application.core.usecase;

import com.github.clovisgargione.application.core.domain.Usuario;
import com.github.clovisgargione.application.ports.in.FindByIdUsuarioInputPort;
import com.github.clovisgargione.application.ports.out.FindByIdUsuarioOutputPort;

public class FindByIdUsuarioUseCase implements FindByIdUsuarioInputPort {

	private final FindByIdUsuarioOutputPort findByIdUsuarioOutputPort;

	public FindByIdUsuarioUseCase(FindByIdUsuarioOutputPort findByIdUsuarioOutputPort) {
		super();
		this.findByIdUsuarioOutputPort = findByIdUsuarioOutputPort;
	}

	@Override
	public Usuario findById(String id) {
		Usuario usuario = this.findByIdUsuarioOutputPort.findById(id);
		return usuario;
	}

}
