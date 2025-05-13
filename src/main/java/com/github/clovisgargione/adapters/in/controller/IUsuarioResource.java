package com.github.clovisgargione.adapters.in.controller;

import org.springframework.http.ResponseEntity;

import com.github.clovisgargione.adapters.in.controller.request.LoginUsuarioRequest;
import com.github.clovisgargione.adapters.in.controller.request.UsuarioRequest;

public interface IUsuarioResource {

	ResponseEntity<?> postUsuario(UsuarioRequest usuarioRequest);
	
	ResponseEntity<?> authenticate(LoginUsuarioRequest login);
}
