package com.github.clovisgargione.adapters.in.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.clovisgargione.adapters.in.controller.request.LoginUsuarioRequest;
import com.github.clovisgargione.adapters.in.controller.request.UsuarioRequest;
import com.github.clovisgargione.adapters.in.controller.response.TokenResponse;
import com.github.clovisgargione.adapters.in.controller.service.AuthenticationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthResource implements IUsuarioResource {

	private final AuthenticationService service;

	@PostMapping("/signup")
	public ResponseEntity<?> postUsuario(@RequestBody UsuarioRequest usuarioRequest) {
		var usuarioResponse = service.signup(usuarioRequest);
		return ResponseEntity.ok(usuarioResponse);
	}
	
	@PostMapping("/signin")
    public ResponseEntity<?> authenticate(@RequestBody LoginUsuarioRequest login) {
        TokenResponse token = service.signin(login);
		return ResponseEntity.ok(token);
    }
}
