package com.github.clovisgargione.application.core.usecase;

import com.github.clovisgargione.adapters.out.exception.UsuarioException;
import com.github.clovisgargione.application.core.domain.Usuario;
import com.github.clovisgargione.application.ports.in.InsertUsuarioInputPort;
import com.github.clovisgargione.application.ports.out.InsertUsuarioOutputPort;

public class InsertUsuarioUseCase implements InsertUsuarioInputPort {

	private final InsertUsuarioOutputPort insertUsuarioOutputPort;
	
	public InsertUsuarioUseCase(InsertUsuarioOutputPort insertUsuarioOutputPort) {
		super();
		this.insertUsuarioOutputPort = insertUsuarioOutputPort;
	}

	@Override
	public Usuario insert(Usuario usuario) throws UsuarioException {
		Usuario novoUsuario = this.insertUsuarioOutputPort.insert(usuario);
		return novoUsuario;
	}

}
