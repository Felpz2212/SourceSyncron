package com.sourcesyncron.v1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourcesyncron.v1.DTO.usuario.UsuarioDTO;
import com.sourcesyncron.v1.DTO.usuario.UsuarioLoginDTO;
import com.sourcesyncron.v1.mapper.usuario.UsuarioMapper;
import com.sourcesyncron.v1.model.Usuario;
import com.sourcesyncron.v1.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository repository;
	
	UsuarioMapper mapper = new UsuarioMapper();
	
	public UsuarioDTO create(Usuario user) {
		return mapper.convertModelToDto(repository.save(user));
	}
	
	public List<UsuarioDTO> findAll(){
		
		List<UsuarioDTO> usuarios = new ArrayList<>();
		List<Usuario> usuariosModel = new ArrayList<>();
		
		usuariosModel = repository.findAll();
		
		for (Usuario u : usuariosModel) {
			UsuarioDTO udto = mapper.convertModelToDto(u);
			
			usuarios.add(udto);
		}
		
		return usuarios;
	}
	
	public UsuarioDTO findById(Long id) throws Exception{
		
		Usuario u = repository.findById(id).orElseThrow(() -> new Exception("Usuario não encontrado"));
		
		return mapper.convertModelToDto(u);
	}
	
	public Usuario findUsuarioById(Long id) throws Exception{
		
		Usuario u = repository.findById(id).orElseThrow(() -> new Exception("Usuario não encontrado"));
		
		return u;
	}

	public UsuarioDTO findByEmail(UsuarioLoginDTO user) throws Exception{
		
		UsuarioDTO u = mapper.convertModelToDto(repository.findByEmail(
				user.getEmail(), 
				user.getPwd()
			).orElseThrow(() ->  new Exception("Email ou senha incorretos"))
		);
		
		return u;
	}

}
