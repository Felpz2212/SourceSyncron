package com.sourcesyncron.v1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sourcesyncron.v1.model.UsuarioTarefas;

public interface UsuarioTarefaRepository extends JpaRepository<UsuarioTarefas, Long> {
	
	@Query(value="SELECT * FROM USUARIOS_TAREFAS WHERE USUARIO_ID = :id", nativeQuery = true)
	public List<UsuarioTarefas> findAllByUsuario(@Param("id") Long id);
	
	@Query(value="SELECT * FROM USUARIOS_TAREFAS WHERE USUARIO_ID = :id  && PROJETO_ID = :id_projeto", nativeQuery = true)
	public List<UsuarioTarefas> findTarefasProjetoByUser(@Param("id") Long id, 
			@Param("id_projeto") Long id_projeto);
}
