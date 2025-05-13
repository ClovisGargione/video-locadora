package com.github.clovisgargione.application.ports.in;

import com.github.clovisgargione.application.core.domain.Usuario;

public interface FindByIdUsuarioInputPort {

	Usuario findById(String id);
}
