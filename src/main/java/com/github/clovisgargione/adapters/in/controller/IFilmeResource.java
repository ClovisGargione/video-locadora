package com.github.clovisgargione.adapters.in.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.github.clovisgargione.adapters.in.controller.exception.UploadFileException;
import com.github.clovisgargione.adapters.in.controller.request.FilmeRequest;

import jakarta.servlet.http.HttpServletRequest;

public interface IFilmeResource {

	ResponseEntity<?> insertFilme(FilmeRequest request);
	
	ResponseEntity<?> updateFilme(FilmeRequest request);
	
	ResponseEntity<?> deleteFilme(String id);
	
	ResponseEntity<?> getFilmeById(String id);
	
	ResponseEntity<?> getFilmeByName(String nome);
	
	ResponseEntity<?> getTodosFilmes();
	
	ResponseEntity<?> uploadFile(String fileName, MultipartFile file, HttpServletRequest request) throws UploadFileException;
}
