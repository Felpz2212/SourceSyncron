package com.sourcesyncron.v1.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sourcesyncron.v1.model.Projeto;
import com.sourcesyncron.v1.service.ProjetoService;

@RestController
@RequestMapping("/api/v1/projeto")
public class ProjetoController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	ProjetoService projetoService;
	
	@GetMapping
	public List<Projeto> findAllProjetos(){
		return projetoService.findAllProjetos();
	}
	
	@GetMapping(value="/{id}")
	public Projeto findById(@PathVariable(name = "id") Long id) throws Exception {
		return projetoService.findById(id);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE)
	public Projeto create(@RequestBody Projeto projeto) {
		return projetoService.create(projeto);
	}
	
}
