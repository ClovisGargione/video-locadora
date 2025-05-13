package com.github.clovisgargione.application.ports.in;

import com.github.clovisgargione.application.core.domain.Filme;

public interface InsertFilmeInputPort {

	Filme insert(Filme filme);
}
