package com.github.clovisgargione.adapters.out;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.github.clovisgargione.adapters.out.repository.FilmeRepository;
import com.github.clovisgargione.adapters.out.repository.entity.FilmeEntity;
import com.github.clovisgargione.adapters.out.repository.mapper.FilmeEntityMapper;
import com.github.clovisgargione.application.core.domain.Filme;
import com.github.clovisgargione.application.ports.out.UpdateCapaFilmeOutputPort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class UpdateCapaFilmeAdapter implements UpdateCapaFilmeOutputPort {

	private final FilmeRepository filmeRepository;

	private final FilmeEntityMapper filmeEntityMapper;

	@Override
	public List<Filme> setCapa(String nome, String capa) {
		List<FilmeEntity> entities = this.filmeRepository.findByNome(nome);
		entities.forEach(e -> {
			e.setCapa(capa);
			this.filmeRepository.save(e);
		});
		List<Filme> filmes = entities.stream().map(e -> this.filmeEntityMapper.toFilme(e)).collect(Collectors.toList());
		return filmes;
	}

}
