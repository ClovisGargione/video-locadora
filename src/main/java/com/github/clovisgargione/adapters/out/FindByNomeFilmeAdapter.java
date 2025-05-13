package com.github.clovisgargione.adapters.out;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.github.clovisgargione.adapters.out.repository.FilmeRepository;
import com.github.clovisgargione.adapters.out.repository.entity.FilmeEntity;
import com.github.clovisgargione.adapters.out.repository.mapper.FilmeEntityMapper;
import com.github.clovisgargione.application.core.domain.Filme;
import com.github.clovisgargione.application.ports.out.FindByNomeFilmeOutputPort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class FindByNomeFilmeAdapter implements FindByNomeFilmeOutputPort {

	private final FilmeRepository filmeRepository;
	
	private final FilmeEntityMapper filmeEntityMapper;
	
	@Override
	public List<Filme> filmes(String nome) {
		List<FilmeEntity> entities = this.filmeRepository.findByNome(nome);
		return entities.stream().map(f -> this.filmeEntityMapper.toFilme(f)).collect(Collectors.toList());
	}

}
