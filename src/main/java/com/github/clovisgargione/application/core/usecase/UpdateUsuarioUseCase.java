package com.github.clovisgargione.application.core.usecase;

import com.github.clovisgargione.adapters.out.exception.UsuarioException;
import com.github.clovisgargione.application.core.domain.Usuario;
import com.github.clovisgargione.application.ports.in.UpdateUsuarioInputPort;
import com.github.clovisgargione.application.ports.out.UpdateUsuarioOutputPort;

public class UpdateUsuarioUseCase implements UpdateUsuarioInputPort {

	private final UpdateUsuarioOutputPort updateUsuarioOutputPort;

	public UpdateUsuarioUseCase(UpdateUsuarioOutputPort updateUsuarioOutputPort) {
		super();
		this.updateUsuarioOutputPort = updateUsuarioOutputPort;
	}

	@Override
	public Usuario update(Usuario usuario) throws UsuarioException {
		Usuario usuarioAtualizado = this.updateUsuarioOutputPort.update(usuario);
		return usuarioAtualizado;
	}

}
