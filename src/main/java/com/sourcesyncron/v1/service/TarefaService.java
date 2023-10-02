package com.sourcesyncron.v1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourcesyncron.v1.model.Tarefa;
import com.sourcesyncron.v1.repositories.TarefaRepository;

@Service
public class TarefaService {
	
	@Autowired
	TarefaRepository tarefaRepository;
	
	public List<Tarefa> findAll(){
		return tarefaRepository.findAll();
	}
	
	public Tarefa findById(Long id) throws Exception {
		return tarefaRepository.findById(id).orElseThrow(() -> new Exception("Tarefa nao encontrada"));
	}
	
	public Tarefa create(Tarefa tarefa) {
		
		return tarefaRepository.save(tarefa);
	}
}
