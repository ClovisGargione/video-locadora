package com.github.clovisgargione.adapters.out.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

import com.github.clovisgargione.adapters.out.repository.entity.FilmeEntity;
import com.github.clovisgargione.application.core.domain.Filme;

@Mapper(componentModel = ComponentModel.SPRING)
public interface FilmeEntityMapper {

	FilmeEntity toFilmeEntity(Filme filme);
	
	Filme toFilme(FilmeEntity filmeEntity);
}
