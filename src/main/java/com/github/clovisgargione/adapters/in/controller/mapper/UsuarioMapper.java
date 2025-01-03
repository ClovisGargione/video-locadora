package com.github.clovisgargione.adapters.in.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.github.clovisgargione.adapters.in.controller.request.UsuarioRequest;
import com.github.clovisgargione.adapters.in.controller.response.UsuarioResponse;
import com.github.clovisgargione.application.core.domain.Usuario;

@Mapper(componentModel = ComponentModel.SPRING, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UsuarioMapper {

	Usuario toUsuario(UsuarioRequest usuarioRequest);
	
	UsuarioResponse toUsuarioResponse(Usuario usuario);
	
}
