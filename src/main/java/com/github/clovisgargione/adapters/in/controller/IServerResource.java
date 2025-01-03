package com.github.clovisgargione.adapters.in.controller;

import org.springframework.http.ResponseEntity;

import jakarta.servlet.http.HttpServletRequest;

public interface IServerResource {

	ResponseEntity<?>	user(HttpServletRequest	request);
}
