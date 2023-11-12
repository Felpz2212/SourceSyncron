package com.sourcesyncron.v1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sourcesyncron.v1.model.UsuariosProjetos;

public interface UsuarioProjetosRepository extends JpaRepository<UsuariosProjetos, Long> {
	
	@Query(value="SELECT * FROM USUARIOS_PROJETOS WHERE USUARIO_ID = :id", nativeQuery = true)
	public List<UsuariosProjetos> findAllByUsuario(@Param("id") Long id);
	
	@Query(value="SELECT * FROM USUARIOS_PROJETOS WHERE PROJETO_ID = :id", nativeQuery = true)
	public List<UsuariosProjetos> findAllUsersByProject(@Param("id") Long id);
}
