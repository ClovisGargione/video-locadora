package com.github.clovisgargione.adapters.out.repository;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.github.clovisgargione.adapters.out.repository.entity.UsuarioEntity;
import com.github.clovisgargione.config.ResourceOwner;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ResourceOwnerService implements UserDetailsService {

	private final UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UsuarioEntity> usuario = repository.findByEmail(username);
		if (usuario.isPresent()) {
			return new ResourceOwner(usuario.get());
		} else {
			throw new UsernameNotFoundException("Usuario não encontrado");
		}
	}

}
