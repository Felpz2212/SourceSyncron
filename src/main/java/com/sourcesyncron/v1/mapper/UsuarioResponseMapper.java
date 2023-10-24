package com.sourcesyncron.v1.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import com.sourcesyncron.v1.DTO.UsuarioResponseDTO;
import com.sourcesyncron.v1.model.Usuario;
import com.sourcesyncron.v1.repositories.UsuarioRepository;

public class UsuarioResponseMapper {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	public UsuarioResponseDTO convertModelToDto(Usuario model) {
		
		String nome = model.getNome();	
		String email = model.getEmail();
		String username = model.getUsername();
		Long id = model.getId();
		
		return new UsuarioResponseDTO(id, nome, email, username);
	}
	
	public Usuario convertDtoToModel(UsuarioResponseDTO DTO) {
		
		Usuario u = usuarioRepository.findById(DTO.getId()).get();
		
		return new Usuario(u.getId(), u.getNome(), u.getEmail(), u.getUsername(), u.getSenha());
	}
}
