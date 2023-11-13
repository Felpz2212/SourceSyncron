package com.sourcesyncron.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sourcesyncron.v1.DTO.UsuarioTarefa.UsuarioTarefaCreateDTO;
import com.sourcesyncron.v1.DTO.UsuarioTarefa.UsuarioTarefaResponseDTO;
import com.sourcesyncron.v1.DTO.tarefa.TarefaCreateDTO;
import com.sourcesyncron.v1.DTO.tarefa.TarefaResponseDTO;
import com.sourcesyncron.v1.mapper.UsuarioTarefaMapper;
import com.sourcesyncron.v1.mapper.tarefa.TarefaMapper;
import com.sourcesyncron.v1.model.Tarefa;
import com.sourcesyncron.v1.model.UsuarioTarefas;
import com.sourcesyncron.v1.service.TarefaService;
import com.sourcesyncron.v1.service.UsuarioTarefaService;

@RestController
@RequestMapping("/api/v1/tarefas")
@CrossOrigin(origins = "http://localhost:4200")
public class TarefaController {
	

	private UsuarioTarefaMapper usuarioTarefaMapper = new UsuarioTarefaMapper();
	private TarefaMapper tarefaMapper = new TarefaMapper();
	
	@Autowired
	UsuarioTarefaService usuarioTarefaService;
	
	@Autowired
	TarefaService tarefaService;
	
	
	@PostMapping()
	public TarefaResponseDTO createTarefa(@RequestBody TarefaCreateDTO tarefa) throws Exception {
		
		return tarefaMapper.convertModelDTO(tarefaService.create(tarefa));
	}
	
	
	@GetMapping("{id}")
	public Tarefa getTarefaById(@PathVariable(name = "id") Long id) throws Exception {
		
		return tarefaService.findById(id);
	}
	
	@GetMapping("usuario")
	public List<UsuarioTarefas> getAllTarefasByUser(@RequestParam("id") Long id) throws Exception{
		return usuarioTarefaService.getUsuariosTarefasByUser(id);
	}
	
	@GetMapping("usuario/{id_projeto}/{id_usuario}")
	public List<UsuarioTarefaResponseDTO> getAllTarefasByProjectAndUser(@PathVariable(name = "id_projeto") Long id_projeto,
			@PathVariable(name = "id_usuario") Long id_usuario) throws Exception{
		return usuarioTarefaService.getUsuariosTarefasByProjectAndUser(id_usuario, id_projeto);
	}
	
	@PostMapping("usuario")
	public UsuarioTarefaResponseDTO create(@RequestBody UsuarioTarefaCreateDTO ut) throws Exception {
		return usuarioTarefaMapper.convertModelDTO(usuarioTarefaService.createUsuarioTarefa(ut));
	}
	
	@PutMapping()
	public TarefaResponseDTO updateTarefa(@RequestBody TarefaCreateDTO t) throws Exception {
		
		return tarefaMapper.convertModelDTO(tarefaService.update(t));
	}
}
