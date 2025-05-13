package com.github.clovisgargione.adapters.out.repository.mapper;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.Named;

import com.github.clovisgargione.adapters.out.repository.entity.UsuarioEntity;
import com.github.clovisgargione.application.core.domain.Usuario;

@Mapper(componentModel = ComponentModel.SPRING)
public interface UsuarioEntityMapper {

	UsuarioEntity toUsuarioEntity(Usuario usuario, @Context CycleAvoidingMappingContext context);
	
	Usuario toUsuario(UsuarioEntity usuarioEntity, @Context CycleAvoidingMappingContext context);
	
	@Named("toUsuarioEntity")
	default UsuarioEntity toUsuarioEntity(Usuario usuario) {
		return toUsuarioEntity(usuario, new CycleAvoidingMappingContext());
	}
	
	@Named("toUsuario")
	default Usuario toUsuario(UsuarioEntity usuarioEntity)  {
		return toUsuario(usuarioEntity, new CycleAvoidingMappingContext());
	}
}
