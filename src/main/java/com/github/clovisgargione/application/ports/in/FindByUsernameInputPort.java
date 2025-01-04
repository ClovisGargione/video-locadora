package com.github.clovisgargione.application.ports.in;

import com.github.clovisgargione.application.core.domain.Usuario;

public interface FindByUsernameInputPort {

	Usuario findByUsername(String username);
}
