package com.github.clovisgargione.adapters.in.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.clovisgargione.adapters.in.controller.mapper.UsuarioMapper;
import com.github.clovisgargione.adapters.in.controller.response.UsuarioResponse;
import com.github.clovisgargione.application.core.domain.Usuario;
import com.github.clovisgargione.application.ports.in.ListUsuarioInputPort;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("usuario")
@RequiredArgsConstructor
public class UsuarioResource {

	private final ListUsuarioInputPort listUsuarioInputPort;
	
	private final UsuarioMapper usuarioMapper;
	
	@PreAuthorize(value = "hasAnyRole('ADMIN', 'SUPER_ADMIN')")
	@GetMapping
	public ResponseEntity<?> getUsuarios(){
		List<Usuario> usuarios = listUsuarioInputPort.listUsuarios();
		List<UsuarioResponse> usuariosResponse = usuarios.stream().map(u -> usuarioMapper.toUsuarioResponse(u)).collect(Collectors.toList());
		return ResponseEntity.ok(usuariosResponse);
	}
}
