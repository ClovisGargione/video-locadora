package com.github.clovisgargione.application.ports.out;

import com.github.clovisgargione.application.core.domain.Usuario;

public interface InsertUsuarioOutputPort {

	Usuario insert(Usuario usuario);
}
