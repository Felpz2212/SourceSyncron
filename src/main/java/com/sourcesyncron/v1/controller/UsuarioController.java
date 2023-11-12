package com.sourcesyncron.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sourcesyncron.v1.DTO.usuario.UsuarioDTO;
import com.sourcesyncron.v1.DTO.usuario.UsuarioLoginDTO;
import com.sourcesyncron.v1.model.Usuario;
import com.sourcesyncron.v1.service.UsuarioService;

@RestController
@RequestMapping("/api/v1/usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
	
	@Autowired
	UsuarioService service;
	
	@PostMapping
	public UsuarioDTO createUser(@RequestBody Usuario u) {
		return service.create(u);
	}
	
	@PostMapping("/login")
	public UsuarioDTO login(@RequestBody UsuarioLoginDTO u) throws Exception {
		return service.findByEmail(u);
	}
}
