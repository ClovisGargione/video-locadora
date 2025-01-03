package com.github.clovisgargione.adapters.in.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.clovisgargione.adapters.in.controller.mapper.UsuarioMapper;
import com.github.clovisgargione.adapters.in.controller.request.UsuarioRequest;
import com.github.clovisgargione.application.ports.in.InsertUsuarioInputPort;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("cadastrar")
@RequiredArgsConstructor
public class CadastrarUsuarioResource implements IUsuarioResource {

	
	private final InsertUsuarioInputPort insertUsuarioInputPort;
	
	private final UsuarioMapper usuarioMapper;
	
	private final PasswordEncoder userPasswordEncoder;

	
	@PostMapping
	public ResponseEntity<?> postUsuario(@RequestBody UsuarioRequest usuarioRequest) {
		usuarioRequest.getCredenciais().setSenha(userPasswordEncoder.encode(usuarioRequest.getCredenciais().getSenha()));
		var usuario = this.usuarioMapper.toUsuario(usuarioRequest);
		var novoUsuario = this.insertUsuarioInputPort.insert(usuario);
		var usuarioResponse = this.usuarioMapper.toUsuarioResponse(novoUsuario);
		return ResponseEntity.ok(usuarioResponse);
	}
}
