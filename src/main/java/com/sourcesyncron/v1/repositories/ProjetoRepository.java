package com.sourcesyncron.v1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sourcesyncron.v1.model.Projeto;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
	
}
