package com.sourcesyncron.v1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sourcesyncron.v1.model.UsuarioTarefas;

public interface UsuarioTarefaRepository extends JpaRepository<UsuarioTarefas, Long> {

}
