package com.github.clovisgargione.adapters.in.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.clovisgargione.adapters.in.controller.mapper.UsuarioMapper;
import com.github.clovisgargione.adapters.in.controller.request.UsuarioRequest;
import com.github.clovisgargione.adapters.in.controller.response.UsuarioResponse;
import com.github.clovisgargione.adapters.out.DeleteUsuarioAdapter;
import com.github.clovisgargione.adapters.out.exception.UsuarioException;
import com.github.clovisgargione.adapters.out.repository.mapper.CycleAvoidingMappingContext;
import com.github.clovisgargione.adapters.out.repository.mapper.UsuarioEntityMapper;
import com.github.clovisgargione.application.core.domain.Usuario;
import com.github.clovisgargione.application.ports.in.FindByIdUsuarioInputPort;
import com.github.clovisgargione.application.ports.in.FindByUsernameInputPort;
import com.github.clovisgargione.application.ports.in.ListUsuarioInputPort;
import com.github.clovisgargione.application.ports.in.UpdateUsuarioInputPort;
import com.github.clovisgargione.config.ResourceOwner;

import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("usuario")
@RequiredArgsConstructor
public class UsuarioResource {

	private final ListUsuarioInputPort listUsuarioInputPort;

	private final UpdateUsuarioInputPort updateUsuarioInputPort;
	
	private final DeleteUsuarioAdapter deleteUsuarioAdapter;
	
	private final FindByUsernameInputPort findByUsernameInputPort;
	
	private final FindByIdUsuarioInputPort findByIdInputPort;

	private final UsuarioMapper usuarioMapper;

	private final UsuarioEntityMapper usuarioEntityMapper;
	
	private final PasswordEncoder userPasswordEncoder;

	@PreAuthorize(value = "hasAnyRole('ADMIN', 'SUPER_ADMIN')")
	@GetMapping
	public ResponseEntity<?> getUsuarios() {
		List<Usuario> usuarios = listUsuarioInputPort.listUsuarios();
		List<UsuarioResponse> usuariosResponse = usuarios.stream().map(u -> usuarioMapper.toUsuarioResponse(u))
				.collect(Collectors.toList());
		return ResponseEntity.ok(usuariosResponse);
	}

	@GetMapping("/me")
	public ResponseEntity<?> authenticatedUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		ResourceOwner resourceOwner = (ResourceOwner) authentication.getPrincipal();

		Usuario usuario = this.usuarioEntityMapper.toUsuario(resourceOwner.getUsuario(),
				new CycleAvoidingMappingContext());

		UsuarioResponse response = this.usuarioMapper.toUsuarioResponse(usuario);

		return ResponseEntity.ok(response);
	}

	@PreAuthorize(value = "hasAnyRole('ADMIN', 'SUPER_ADMIN')")
	@PutMapping
	public ResponseEntity<?> updateUsuario(@RequestBody UsuarioRequest usuarioRequest) {
		usuarioRequest.getCredenciais().setSenha(userPasswordEncoder.encode(usuarioRequest.getCredenciais().getSenha()));
		Usuario usuario = this.usuarioMapper.toUsuario(usuarioRequest);
		try {
			usuario = this.updateUsuarioInputPort.update(usuario);
		} catch (UsuarioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		UsuarioResponse response = this.usuarioMapper.toUsuarioResponse(usuario);
		return ResponseEntity.ok(response);
	}

	@PreAuthorize(value = "hasAnyRole('ADMIN', 'SUPER_ADMIN')")
	@DeleteMapping(path = "{id}")
	public ResponseEntity<?> deleteUsuario(@PathVariable String id) {
		this.deleteUsuarioAdapter.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(params = "username")
	public ResponseEntity<?> findByUsername(@RequestParam String username){
		if(StringUtils.isBlank(username)) {
			return ResponseEntity.badRequest().body("Usuário não informado");
		}
		Usuario usuario = this.findByUsernameInputPort.findByUsername(username);
		UsuarioResponse response = this.usuarioMapper.toUsuarioResponse(usuario);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(params = "id")
	public ResponseEntity<?> findById(@RequestParam String id){
		if(StringUtils.isBlank(id)) {
			return ResponseEntity.badRequest().body("Id não informado");
		}
		Usuario usuario = this.findByIdInputPort.findById(id);
		UsuarioResponse response = this.usuarioMapper.toUsuarioResponse(usuario);
		return ResponseEntity.ok(response);
	}
}
