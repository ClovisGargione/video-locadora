package com.github.clovisgargione.adapters.out;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.github.clovisgargione.adapters.out.repository.UsuarioRepository;
import com.github.clovisgargione.adapters.out.repository.entity.UsuarioEntity;
import com.github.clovisgargione.adapters.out.repository.mapper.UsuarioEntityMapper;
import com.github.clovisgargione.application.core.domain.Usuario;
import com.github.clovisgargione.application.ports.out.FindByIdUsuarioOutputPort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class FindByIdUsuarioAdapter implements FindByIdUsuarioOutputPort {

	private final UsuarioRepository usuarioRepository;

	private final UsuarioEntityMapper usuarioEntityMapper;
	
	@Override
	public Usuario findById(String id) {
		Optional<UsuarioEntity> entity = this.usuarioRepository.findById(id); 
		Usuario usuario = this.usuarioEntityMapper.toUsuario(entity.orElseThrow());
		return usuario;
	}

}
