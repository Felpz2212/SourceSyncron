package com.sourcesyncron.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sourcesyncron.v1.DTO.UsuarioProjeto.UsuarioProjetoResponseDTO;
import com.sourcesyncron.v1.DTO.projeto.ProjetoCreateDTO;
import com.sourcesyncron.v1.DTO.projeto.ProjetoResponseDTO;
import com.sourcesyncron.v1.service.ProjetoService;
import com.sourcesyncron.v1.service.UsuariosProjetosService;

@RestController
@RequestMapping("/api/v1/projetos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProjetoController {

	@Autowired
	ProjetoService projetoService;
	
	@Autowired
	UsuariosProjetosService usuarioProjetoService;
	
	@GetMapping("usuario")
	public List<UsuarioProjetoResponseDTO> getAllProjectsByUser(@RequestParam("id") Long id) throws Exception{
		
		return usuarioProjetoService.findByUsuario(id);	
	}
	
	@PostMapping
	public ProjetoResponseDTO create(@RequestBody ProjetoCreateDTO projeto) throws Exception {
	
		return projetoService.create(projeto);
		
	}
	
	@GetMapping("/{id}")
	public ProjetoResponseDTO getById(@PathVariable(name = "id") Long id) throws Exception {
		
		return projetoService.findById(id);
	}
	
	@GetMapping("all-users")
	public List<UsuarioProjetoResponseDTO> getAllUsers(@RequestParam("id") Long id) {
		
		return usuarioProjetoService.findUsersByProject(id);
	}
}
