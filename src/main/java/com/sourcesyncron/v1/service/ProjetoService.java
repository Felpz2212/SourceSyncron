package com.sourcesyncron.v1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourcesyncron.v1.model.Projeto;
import com.sourcesyncron.v1.repositories.ProjetoRepository;

@Service
public class ProjetoService {
	
	@Autowired
	ProjetoRepository projetoRepository;
	
	public List<Projeto> findAllProjetos(){
		
		return projetoRepository.findAll();
	}
	
	public Projeto findById(Long id) throws Exception{
		
		return projetoRepository.findById(id).orElseThrow(
				() -> new Exception("Projeto nao encontrado"));
	}
	
	public Projeto create(Projeto projeto) {
		return projetoRepository.save(projeto);
	}
}
