package com.github.clovisgargione.adapters.out;

import java.util.List;
import static java.util.Objects.nonNull;

import org.springframework.stereotype.Component;

import com.github.clovisgargione.adapters.out.repository.FilmeRepository;
import com.github.clovisgargione.adapters.out.repository.entity.FilmeEntity;
import com.github.clovisgargione.adapters.out.repository.mapper.FilmeEntityMapper;
import com.github.clovisgargione.application.core.domain.Filme;
import com.github.clovisgargione.application.ports.out.InsertFilmeOutputPort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class InsertFilmeAdapter implements InsertFilmeOutputPort {

	private final FilmeRepository filmeRepository;
	
	private final FilmeEntityMapper filmeEntityMapper;
	
	@Override
	public Filme insert(Filme filme) {
		List<FilmeEntity> entities = this.filmeRepository.findByNome(filme.getNome());
		entities.forEach(e -> {
			if(nonNull(e.getCapa())) {
				filme.setCapa(e.getCapa());
				return;
			}
		});
		FilmeEntity entity = this.filmeEntityMapper.toFilmeEntity(filme);
		entity = this.filmeRepository.save(entity);
		Filme novoFilme = this.filmeEntityMapper.toFilme(entity);
		return novoFilme;
	}

}
