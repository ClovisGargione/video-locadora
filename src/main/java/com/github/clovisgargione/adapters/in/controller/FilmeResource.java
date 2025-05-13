package com.github.clovisgargione.adapters.in.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.github.clovisgargione.adapters.in.controller.exception.UploadFileException;
import com.github.clovisgargione.adapters.in.controller.mapper.FilmeMapper;
import com.github.clovisgargione.adapters.in.controller.request.FilmeRequest;
import com.github.clovisgargione.adapters.in.controller.response.FilmeResponse;
import com.github.clovisgargione.adapters.in.controller.service.FileProcessingService;
import com.github.clovisgargione.application.core.domain.Filme;
import com.github.clovisgargione.application.ports.in.FindByNomeFilmeInputPort;
import com.github.clovisgargione.application.ports.in.InsertFilmeInputPort;
import com.github.clovisgargione.application.ports.in.ListFilmeInputPort;
import com.github.clovisgargione.application.ports.in.UpdateCapaFilmeInputPort;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("filme")
public class FilmeResource implements IFilmeResource{
	
	private final InsertFilmeInputPort insertFilmeInputPort;
	
	private final FilmeMapper filmeMapper;

	private final ListFilmeInputPort listFilmeInputPort;
	
	private final FindByNomeFilmeInputPort findByNomeFilmeInputPort;
	
	private final FileProcessingService fileProcessingService;
	
	private final UpdateCapaFilmeInputPort updateCapaFilmeInputPort;

	@PreAuthorize(value = "hasAnyRole('ADMIN', 'SUPER_ADMIN')")
	@PostMapping
	@Override
	public ResponseEntity<?> insertFilme(@RequestBody FilmeRequest request) {
		Filme filme = this.filmeMapper.toFilme(request);
		filme = this.insertFilmeInputPort.insert(filme);
		return ResponseEntity.ok(filme);
	}

	@PutMapping
	@Override
	public ResponseEntity<?> updateFilme(FilmeRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@DeleteMapping(path = "{id}")
	@Override
	public ResponseEntity<?> deleteFilme(@PathVariable String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping(params = "id")
	@Override
	public ResponseEntity<?> getFilmeById(@RequestParam String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping(params = "nome")
	@Override
	public ResponseEntity<?> getFilmeByName(@RequestParam String nome) {
		List<Filme> filmes = this.findByNomeFilmeInputPort.filmes(nome);
		List<FilmeResponse> response = filmes.stream().map(f -> this.filmeMapper.toFilmeResponse(f)).collect(Collectors.toList());
		return ResponseEntity.ok(response);
	}

	@PreAuthorize(value = "hasRole('USER')")
	@GetMapping
	@Override
	public ResponseEntity<?> getTodosFilmes() {
		List<Filme> filmes = this.listFilmeInputPort.filmes();
		List<FilmeResponse> response = filmes.stream().map(f -> this.filmeMapper.toFilmeResponse(f)).collect(Collectors.toList());
		return ResponseEntity.ok(response);
	}

	@PreAuthorize(value = "hasAnyRole('ADMIN', 'SUPER_ADMIN')")
	@PostMapping(path ="upload-capa", params = {"nomeFilme"})
	@Override
	public ResponseEntity<?> uploadFile(@RequestParam String nomeFilme, @RequestParam MultipartFile file, HttpServletRequest request) throws UploadFileException {
		String requestUrl = request.getRequestURL().toString();
		String tenant = request.getHeader("X-TenantID");
		String nomeArquivo = this.fileProcessingService.uploadFile(nomeFilme, file, tenant);
		String urlCapa = this.fileProcessingService.localImagemCapa(nomeArquivo, requestUrl);
		this.updateCapaFilmeInputPort.setCapa(nomeFilme, urlCapa);
		return ResponseEntity.status(HttpStatus.CREATED).body(urlCapa);
	}
}
