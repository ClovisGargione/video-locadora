package com.github.clovisgargione.application.core.usecase;

import com.github.clovisgargione.application.ports.in.DeleteUsuarioInputPort;
import com.github.clovisgargione.application.ports.out.DeleteUsuarioOutputPort;

public class DeleteUsuarioUseCase implements DeleteUsuarioInputPort {

	private final DeleteUsuarioOutputPort deleteUsuarioOutputPort;

	public DeleteUsuarioUseCase(DeleteUsuarioOutputPort deleteUsuarioOutputPort) {
		super();
		this.deleteUsuarioOutputPort = deleteUsuarioOutputPort;
	}

	@Override
	public void delete(String id) {
		this.deleteUsuarioOutputPort.delete(id);
	}

}
