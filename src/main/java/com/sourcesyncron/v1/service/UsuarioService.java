package com.sourcesyncron.v1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourcesyncron.v1.DTO.UsuarioResponseDTO;
import com.sourcesyncron.v1.mapper.UsuarioResponseMapper;
import com.sourcesyncron.v1.model.Usuario;
import com.sourcesyncron.v1.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository repository;
	
	UsuarioResponseMapper mapper = new UsuarioResponseMapper();
	
	public UsuarioResponseDTO create(Usuario user) {
		return mapper.convertModelToDto(repository.save(user));
	}
	
	public List<UsuarioResponseDTO> findAll(){
		
		List<UsuarioResponseDTO> usuarios = new ArrayList<>();
		List<Usuario> usuariosModel = new ArrayList<>();
		
		usuariosModel = repository.findAll();
		
		for (Usuario u : usuariosModel) {
			UsuarioResponseDTO udto = mapper.convertModelToDto(u);
			
			usuarios.add(udto);
		}
		
		return usuarios;
	}
	
	public UsuarioResponseDTO findById(Long id) throws Exception{
		
		Usuario u = repository.findById(id).orElseThrow(() -> new Exception("Usuario não encontrado"));
		
		return mapper.convertModelToDto(u);
	}
}
