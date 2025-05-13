package com.github.clovisgargione.adapters.out;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.github.clovisgargione.adapters.out.repository.FilmeRepository;
import com.github.clovisgargione.adapters.out.repository.entity.FilmeEntity;
import com.github.clovisgargione.adapters.out.repository.mapper.FilmeEntityMapper;
import com.github.clovisgargione.application.core.domain.Filme;
import com.github.clovisgargione.application.ports.out.ListFilmeOutputPort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class ListFilmeAdapter implements ListFilmeOutputPort {

	private final FilmeRepository repository;
	
	private final FilmeEntityMapper filmeEntityMapper;
	
	@Override
	public List<Filme> filmes() {
		List<FilmeEntity> entities = this.repository.findAll(); 
		return entities.stream().map(f -> this.filmeEntityMapper.toFilme(f)).collect(Collectors.toList());
	}

}
