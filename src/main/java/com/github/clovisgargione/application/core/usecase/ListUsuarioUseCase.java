package com.github.clovisgargione.application.core.usecase;

import java.util.List;

import com.github.clovisgargione.application.core.domain.Usuario;
import com.github.clovisgargione.application.ports.in.ListUsuarioInputPort;
import com.github.clovisgargione.application.ports.out.ListUsuarioOutputPort;

public class ListUsuarioUseCase implements ListUsuarioInputPort {

	private final ListUsuarioOutputPort listUsuarioOutputPort;

	public ListUsuarioUseCase(ListUsuarioOutputPort listUsuarioOutputPort) {
		super();
		this.listUsuarioOutputPort = listUsuarioOutputPort;
	}

	@Override
	public List<Usuario> listUsuarios() {
		List<Usuario> usuarios = this.listUsuarioOutputPort.listUsuarios();
		return usuarios;
	}

}
