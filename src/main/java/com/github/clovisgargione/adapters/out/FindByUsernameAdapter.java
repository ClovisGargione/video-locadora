package com.github.clovisgargione.adapters.out;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.github.clovisgargione.adapters.out.repository.UsuarioRepository;
import com.github.clovisgargione.adapters.out.repository.entity.UsuarioEntity;
import com.github.clovisgargione.adapters.out.repository.mapper.CycleAvoidingMappingContext;
import com.github.clovisgargione.adapters.out.repository.mapper.UsuarioEntityMapper;
import com.github.clovisgargione.application.core.domain.Usuario;
import com.github.clovisgargione.application.ports.out.FindByUsernameOutputPort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class FindByUsernameAdapter implements FindByUsernameOutputPort {

	private final UsuarioRepository usuarioRepository;

	private final UsuarioEntityMapper usuarioEntityMapper;
	
	@Override
	public Usuario findByUsername(String username) {
		Optional<UsuarioEntity> usuarioEntity = this.usuarioRepository.findByEmail(username);
		Usuario usuario = usuarioEntityMapper.toUsuario(usuarioEntity.orElse(null), new CycleAvoidingMappingContext());
		return usuario;
	}

}
