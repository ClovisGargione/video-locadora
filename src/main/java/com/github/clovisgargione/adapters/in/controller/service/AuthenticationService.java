package com.github.clovisgargione.adapters.in.controller.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.github.clovisgargione.adapters.in.controller.mapper.UsuarioMapper;
import com.github.clovisgargione.adapters.in.controller.request.LoginUsuarioRequest;
import com.github.clovisgargione.adapters.in.controller.request.UsuarioRequest;
import com.github.clovisgargione.adapters.in.controller.response.TokenResponse;
import com.github.clovisgargione.adapters.in.controller.response.UsuarioResponse;
import com.github.clovisgargione.adapters.out.exception.UsuarioException;
import com.github.clovisgargione.adapters.out.repository.entity.UsuarioEntity;
import com.github.clovisgargione.adapters.out.repository.mapper.UsuarioEntityMapper;
import com.github.clovisgargione.adapters.out.service.JwtService;
import com.github.clovisgargione.application.core.domain.Usuario;
import com.github.clovisgargione.application.ports.in.FindByUsernameInputPort;
import com.github.clovisgargione.application.ports.in.InsertUsuarioInputPort;
import com.github.clovisgargione.config.ResourceOwner;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthenticationService {

	private final PasswordEncoder userPasswordEncoder;
	
	private final AuthenticationManager authenticationManager;
	
	private final FindByUsernameInputPort findByUsernameInputPort;
	
	private final InsertUsuarioInputPort insertUsuarioInputPort;
	
	private final UsuarioMapper usuarioMapper;
	
	private final JwtService jwtService;
	
	private final UsuarioEntityMapper usuarioEntityMapper;
	
	public UsuarioResponse signup(UsuarioRequest usuarioRequest) throws UsuarioException {
		usuarioRequest.getCredenciais().setSenha(userPasswordEncoder.encode(usuarioRequest.getCredenciais().getSenha()));
		var usuario = this.usuarioMapper.toUsuario(usuarioRequest);
		var novoUsuario = this.insertUsuarioInputPort.insert(usuario);
		var usuarioResponse = this.usuarioMapper.toUsuarioResponse(novoUsuario);
		return usuarioResponse;
	}
	
	
	public TokenResponse signin(LoginUsuarioRequest input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );
        Usuario usuario = this.findByUsernameInputPort.findByUsername(input.getEmail());
        UsuarioEntity entity = usuarioEntityMapper.toUsuarioEntity(usuario);
        String jwtToken = jwtService.generateToken(new ResourceOwner(entity));
        TokenResponse response = new TokenResponse(jwtToken, jwtService.getExpirationTime());
        return response;
    }
	
}
