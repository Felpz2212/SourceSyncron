package com.sourcesyncron.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sourcesyncron.v1.model.Tarefa;
import com.sourcesyncron.v1.service.TarefaService;

public class TarefaController {

	
	@Autowired
	TarefaService tarefaService;
	
	@GetMapping
	public List<Tarefa> findAll(){
		return tarefaService.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Tarefa findById(@PathVariable(name = "id")Long id) throws Exception{
		return tarefaService.findById(id);
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Tarefa create(@RequestBody Tarefa tarefa) {
		return tarefaService.create(tarefa);
	}
}
