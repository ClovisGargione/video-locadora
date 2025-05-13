package com.github.clovisgargione.application.ports.out;

import com.github.clovisgargione.adapters.out.exception.UsuarioException;
import com.github.clovisgargione.application.core.domain.Usuario;

public interface UpdateUsuarioOutputPort {

	Usuario update(Usuario usuario) throws UsuarioException;
}
