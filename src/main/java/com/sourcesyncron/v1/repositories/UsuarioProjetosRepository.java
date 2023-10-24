package com.sourcesyncron.v1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sourcesyncron.v1.model.Usuario;
import com.sourcesyncron.v1.model.UsuariosProjetos;

public interface UsuarioProjetosRepository extends JpaRepository<UsuariosProjetos, Long> {
	
	public List<UsuariosProjetos> findAllByUsuario(Usuario u);
}
