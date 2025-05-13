package com.github.clovisgargione.application.ports.in;

import com.github.clovisgargione.adapters.out.exception.UsuarioException;
import com.github.clovisgargione.application.core.domain.Usuario;

public interface UpdateUsuarioInputPort {

	Usuario update(Usuario usuario) throws UsuarioException;
}
