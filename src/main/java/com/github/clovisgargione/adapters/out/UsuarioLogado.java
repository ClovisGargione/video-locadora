package com.github.clovisgargione.adapters.out;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.github.clovisgargione.adapters.out.repository.UsuarioRepository;
import com.github.clovisgargione.adapters.out.repository.entity.UsuarioEntity;
import com.github.clovisgargione.config.ResourceOwner;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UsuarioLogado {

	private UsuarioRepository repository;
	
	public UsuarioEntity resourceOwner() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		ResourceOwner usuario = (ResourceOwner) authentication.getPrincipal();
		return repository.findById(usuario.getId()).orElseThrow();
	}
}
