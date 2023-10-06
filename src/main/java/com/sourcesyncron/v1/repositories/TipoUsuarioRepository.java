package com.sourcesyncron.v1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sourcesyncron.v1.model.TiposUsuarios;

public interface TipoUsuarioRepository extends JpaRepository<TiposUsuarios, Long>{

}
