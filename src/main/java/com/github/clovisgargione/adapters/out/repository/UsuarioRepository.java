package com.github.clovisgargione.adapters.out.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.github.clovisgargione.adapters.out.repository.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, String> {

	@Query("select u from UsuarioEntity u where u.credenciais.email = :email")
	Optional<UsuarioEntity> findByEmail(@Param("email") String email);
}
