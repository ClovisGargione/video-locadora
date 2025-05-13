package com.github.clovisgargione.adapters.in.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.github.clovisgargione.adapters.in.controller.request.FilmeRequest;
import com.github.clovisgargione.adapters.in.controller.response.FilmeResponse;
import com.github.clovisgargione.application.core.domain.Filme;

@Mapper(componentModel = ComponentModel.SPRING, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface FilmeMapper {

	Filme toFilme(FilmeRequest request);
	
	FilmeResponse toFilmeResponse(Filme filme);
}
