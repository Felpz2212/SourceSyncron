package com.sourcesyncron.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sourcesyncron.v1.DTO.UsuarioProjetoDTO;
import com.sourcesyncron.v1.DTO.UsuarioTarefaDTO;
import com.sourcesyncron.v1.model.Usuario;
import com.sourcesyncron.v1.model.UsuarioTarefas;
import com.sourcesyncron.v1.model.UsuariosProjetos;
import com.sourcesyncron.v1.service.UsuarioService;
import com.sourcesyncron.v1.service.UsuarioTarefaService;
import com.sourcesyncron.v1.service.UsuariosProjetosService;

@RestController()
@RequestMapping("/api/v1/usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	UsuariosProjetosService usuarioProjetoService;
	
	@Autowired
	UsuarioTarefaService usuarioTarefaService;
	
	@GetMapping
	public List<Usuario> findAllUsuarios() {
		return usuarioService.findAll();
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE)
	public Usuario createUser(@RequestBody Usuario u) {
		
		return usuarioService.create(u);
	}
	
	@GetMapping(value = "/{id}")
	public Usuario findById(@PathVariable(name = "id") Long id) throws Exception {
		return usuarioService.findById(id);
	}
	
	@PostMapping(value = "/projeto")
	public UsuariosProjetos createUserProject(@RequestBody UsuarioProjetoDTO usuarioProjeto) throws Exception {
		return usuarioProjetoService.create(usuarioProjeto);
	}
	
	@PostMapping(value="/tarefa")
	public UsuarioTarefas createUserTarefa(@RequestBody UsuarioTarefaDTO usuarioTarefa) throws Exception {
		
		return usuarioTarefaService.createUsuarioTarefa(usuarioTarefa);
	}
}
