package com.github.clovisgargione.application.ports.out;

import java.util.List;

import com.github.clovisgargione.application.core.domain.Usuario;

public interface ListUsuarioOutputPort {

	List<Usuario> listUsuarios();
}
