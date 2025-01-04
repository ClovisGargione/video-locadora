package com.github.clovisgargione.application.ports.out;

import com.github.clovisgargione.application.core.domain.Usuario;

public interface FindByUsernameOutputPort {

	Usuario findByUsername(String username);
}
