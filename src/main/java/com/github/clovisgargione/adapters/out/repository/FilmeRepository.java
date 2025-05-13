package com.github.clovisgargione.adapters.out.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.clovisgargione.adapters.out.repository.entity.FilmeEntity;

public interface FilmeRepository extends JpaRepository<FilmeEntity, String>{

	List<FilmeEntity> findByNome(String nome);
}
