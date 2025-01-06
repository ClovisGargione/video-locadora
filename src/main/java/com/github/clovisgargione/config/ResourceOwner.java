package com.github.clovisgargione.config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.github.clovisgargione.adapters.out.repository.entity.UsuarioEntity;

public class ResourceOwner implements UserDetails {

	private static final long serialVersionUID = 1L;

	private UsuarioEntity usuario;

	public ResourceOwner(UsuarioEntity usuario) {
		super();
		this.usuario = usuario;
	}
	
	public String getId() {
		return usuario.getId();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.usuario.mapToGrantedAuthorities();
	}

	@Override
	public String getPassword() {
		return this.usuario.getCredenciais().getSenha();
	}

	@Override
	public String getUsername() {
		return this.usuario.getCredenciais().getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.usuario.getCredenciais().isContaNaoExpirada();
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.usuario.getCredenciais().isContaNaoBloqueada();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.usuario.getCredenciais().isCredencialNaoExpirada();
	}

	@Override
	public boolean isEnabled() {
		return this.usuario.getCredenciais().isHabilitado();
	}
	
	public UsuarioEntity getUsuario() {
		return this.usuario;
	}

}
