package com.github.clovisgargione.adapters.out;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.github.clovisgargione.adapters.out.exception.UsuarioException;
import com.github.clovisgargione.adapters.out.repository.UsuarioRepository;
import com.github.clovisgargione.adapters.out.repository.entity.UsuarioEntity;
import com.github.clovisgargione.adapters.out.repository.mapper.UsuarioEntityMapper;
import com.github.clovisgargione.application.core.domain.Usuario;
import com.github.clovisgargione.application.ports.out.UpdateUsuarioOutputPort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class UpdateUsuarioAdapter implements UpdateUsuarioOutputPort {

	private final UsuarioRepository usuarioRepository;

	private final UsuarioEntityMapper usuarioEntityMapper;

	@Override
	public Usuario update(Usuario usuario) throws UsuarioException {
		Optional<UsuarioEntity> entity = this.usuarioRepository.findByEmail(usuario.getCredenciais().getEmail());
		if(entity.isPresent() && !entity.get().getId().equals(usuario.getId())) {
			throw new UsuarioException("Usuário já cadastrado, escolha outro email.");
		}
		UsuarioEntity usuarioEntity = this.usuarioEntityMapper.toUsuarioEntity(usuario);
		usuarioEntity = this.usuarioRepository.save(usuarioEntity);
		Usuario usuarioAtualizado = this.usuarioEntityMapper.toUsuario(usuarioEntity);
		return usuarioAtualizado;
	}

}
