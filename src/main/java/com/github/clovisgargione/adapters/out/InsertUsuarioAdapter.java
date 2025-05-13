package com.github.clovisgargione.adapters.out;

import org.springframework.stereotype.Component;

import com.github.clovisgargione.adapters.out.exception.UsuarioException;
import com.github.clovisgargione.adapters.out.repository.UsuarioRepository;
import com.github.clovisgargione.adapters.out.repository.entity.EnderecoEntity;
import com.github.clovisgargione.adapters.out.repository.mapper.UsuarioEntityMapper;
import com.github.clovisgargione.application.core.domain.Usuario;
import com.github.clovisgargione.application.ports.out.InsertUsuarioOutputPort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class InsertUsuarioAdapter implements InsertUsuarioOutputPort {

	private final UsuarioRepository usuarioRepository;

	private final UsuarioEntityMapper usuarioEntityMapper;

	@Override
	public Usuario insert(Usuario usuario) throws UsuarioException {
		if(this.usuarioRepository.findByEmail(usuario.getCredenciais().getEmail()).isPresent()) {
			throw new UsuarioException("Usuário já cadastrado, escolha outro email.");
		}
		var usuarioEntity = this.usuarioEntityMapper.toUsuarioEntity(usuario);
		EnderecoEntity endereco = usuarioEntity.getEndereco();
		endereco.setUsuario(usuarioEntity);
		this.usuarioRepository.save(usuarioEntity);
		Usuario novoUsuario = this.usuarioEntityMapper.toUsuario(usuarioEntity);
		return novoUsuario;
	}

}
