package com.sourcesyncron.v1.mapper.usuario;

import org.springframework.beans.factory.annotation.Autowired;

import com.sourcesyncron.v1.DTO.usuario.UsuarioDTO;
import com.sourcesyncron.v1.model.Usuario;
import com.sourcesyncron.v1.repositories.UsuarioRepository;

public class UsuarioMapper {
	
	@Autowired
	UsuarioRepository repository;
	
	public UsuarioDTO convertModelToDto(Usuario model) {
		
		String nome = model.getNome();	
		String email = model.getEmail();
		String username = model.getUsername();
		Long id = model.getId();
		
		return new UsuarioDTO(id, nome, email, username);
	}
	
	
	public Usuario convertDtoToModel(UsuarioDTO u) {
		
		return repository.findById(u.getId()).get();
	}
}
