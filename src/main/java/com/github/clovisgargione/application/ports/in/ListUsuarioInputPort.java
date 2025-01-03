package com.github.clovisgargione.application.ports.in;

import java.util.List;

import com.github.clovisgargione.application.core.domain.Usuario;

public interface ListUsuarioInputPort {

	List<Usuario> listUsuarios();
}
