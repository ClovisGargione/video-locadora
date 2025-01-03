package com.github.clovisgargione.adapters.out;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.github.clovisgargione.adapters.out.repository.UsuarioRepository;
import com.github.clovisgargione.adapters.out.repository.entity.UsuarioEntity;
import com.github.clovisgargione.adapters.out.repository.mapper.CycleAvoidingMappingContext;
import com.github.clovisgargione.adapters.out.repository.mapper.UsuarioEntityMapper;
import com.github.clovisgargione.application.core.domain.Usuario;
import com.github.clovisgargione.application.ports.out.ListUsuarioOutputPort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class ListUsuarioAdapter implements ListUsuarioOutputPort {

	private final UsuarioRepository usuarioRepository;

	private final UsuarioEntityMapper usuarioEntityMapper;

	@Override
	public List<Usuario> listUsuarios() {
		List<UsuarioEntity> usuarios = usuarioRepository.findAll();

		return usuarios.stream().map(u -> usuarioEntityMapper.toUsuario(u, new CycleAvoidingMappingContext()))
				.collect(Collectors.toList());
	}

}
