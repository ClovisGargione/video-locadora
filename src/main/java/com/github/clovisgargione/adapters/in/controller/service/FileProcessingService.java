package com.github.clovisgargione.adapters.in.controller.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.clovisgargione.adapters.in.controller.exception.UploadFileException;

@Service
public class FileProcessingService {

	private final Path root = Paths.get("src/main/resources/");

	@Value("${uploadFiles}")
	private String diretorioCapas;

	public String localImagemCapa(String nomeArquivo, String requestUrl) {
		String[] parts = requestUrl.split("filme");
		return parts[0].concat(diretorioCapas).concat(nomeArquivo);
	}

	public String uploadFile(String fileName, MultipartFile multipartFile, String tenant) throws UploadFileException {
		String contentType = multipartFile.getContentType();
		if (!contentType.equals(MediaType.IMAGE_JPEG_VALUE) && !contentType.equals(MediaType.IMAGE_PNG_VALUE)) {
			throw new IllegalArgumentException("Only JPEG or PNG images are allowed");
		}

		String originalFilename = multipartFile.getOriginalFilename();

		String[] nomeParts = originalFilename.split("\\.");
		String nomeArquivo = fileName.concat(".").concat(nomeParts[1]);
		
		File dirTenant = new File(this.root.resolve(Paths.get(diretorioCapas.concat(tenant))).normalize()
				.toAbsolutePath().toString());
		
		if (!dirTenant.exists()) {
			dirTenant.mkdir();
		}

		File FileTenant = new File(this.root.resolve(Paths.get(diretorioCapas.concat(tenant).concat("/").concat(nomeArquivo))).normalize()
				.toAbsolutePath().toString());

		if (FileTenant.exists()) {
			return nomeArquivo;
		}

		Path destinationFile = this.root.resolve(Paths.get(diretorioCapas.concat(tenant).concat("/").concat(nomeArquivo))).normalize()
				.toAbsolutePath();

		try {
			Files.copy(multipartFile.getInputStream(), destinationFile, StandardCopyOption.REPLACE_EXISTING);
			return nomeArquivo;
		} catch (Exception e) {
			throw new UploadFileException(e.getMessage());
		}
	}
}
