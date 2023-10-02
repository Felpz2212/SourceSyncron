package com.sourcesyncron.v1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourcesyncron.v1.model.Usuario;
import com.sourcesyncron.v1.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository repository;
	
	public Usuario create(Usuario user) {
		return repository.save(user);
	}
	
	public List<Usuario> findAll(){
		
		return repository.findAll();
	}
	
	public Usuario findById(Long id) throws Exception{
		
		Usuario u = repository.findById(id).orElseThrow(() -> new Exception("Usuario não encontrado"));
		
		return u;
	}
}
