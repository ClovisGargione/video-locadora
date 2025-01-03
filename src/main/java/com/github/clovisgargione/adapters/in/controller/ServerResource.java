package com.github.clovisgargione.adapters.in.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("server")
public class ServerResource implements IServerResource {

	@GetMapping
	public	ResponseEntity<?>	user(HttpServletRequest	request)	{	
		var server = request.getServerName()+":"+request.getServerPort();
		return ResponseEntity.ok(server); 
	}
}
