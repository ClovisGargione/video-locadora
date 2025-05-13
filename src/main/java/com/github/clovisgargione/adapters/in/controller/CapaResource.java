package com.github.clovisgargione.adapters.in.controller;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("capa")
public class CapaResource {
	
	@Value("${uploadFiles}")
	private String diretorioCapas;

	@PreAuthorize(value = "hasRole('USER')")
	@GetMapping(path = "{nomeCapa}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
	public ResponseEntity<?> getCapa(@PathVariable String nomeCapa, HttpServletRequest request) throws IOException {
		String separador = "/";
		String tenant = request.getHeader("X-TenantID");
		InputStream in = getClass()
			      .getResourceAsStream(separador.concat(diretorioCapas).concat(tenant).concat(separador).concat(nomeCapa));
		return ResponseEntity.ok(IOUtils.toByteArray(in));
	}
}
