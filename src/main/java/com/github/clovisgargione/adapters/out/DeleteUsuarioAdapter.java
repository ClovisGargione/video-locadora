package com.github.clovisgargione.adapters.out;

import org.springframework.stereotype.Component;

import com.github.clovisgargione.adapters.out.repository.UsuarioRepository;
import com.github.clovisgargione.application.ports.out.DeleteUsuarioOutputPort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class DeleteUsuarioAdapter implements DeleteUsuarioOutputPort{

	private final UsuarioRepository usuarioRepository;

	@Override
	public void delete(String id) {
		usuarioRepository.deleteById(id);
		
	}
}
