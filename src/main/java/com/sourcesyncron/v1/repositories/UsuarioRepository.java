package com.sourcesyncron.v1.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sourcesyncron.v1.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	@Query(value = "SELECT * FROM usuarios WHERE(EMAIL= :email and SENHA= :senha)", nativeQuery = true)
	public Optional<Usuario> findByEmail(@Param("email") String email,
			@Param("senha") String senha);
}
