package com.github.clovisgargione.application.ports.out;

import com.github.clovisgargione.application.core.domain.Filme;

public interface InsertFilmeOutputPort {

	Filme insert(Filme filme);
}
