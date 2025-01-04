package com.github.clovisgargione.application.core.usecase;

import com.github.clovisgargione.application.core.domain.Usuario;
import com.github.clovisgargione.application.ports.in.FindByUsernameInputPort;
import com.github.clovisgargione.application.ports.out.FindByUsernameOutputPort;

public class FindByUsernameUseCase implements FindByUsernameInputPort {

	private final FindByUsernameOutputPort findByUsernameOutputPort;

	public FindByUsernameUseCase(FindByUsernameOutputPort findByUsernameOutputPort) {
		super();
		this.findByUsernameOutputPort = findByUsernameOutputPort;
	}

	@Override
	public Usuario findByUsername(String username) {
		Usuario usuario = this.findByUsernameOutputPort.findByUsername(username);
		return usuario;
	}

}
