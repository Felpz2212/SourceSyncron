package com.sourcesyncron.v1.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourcesyncron.v1.DTO.UsuarioProjetoDTO;
import com.sourcesyncron.v1.model.Projeto;
import com.sourcesyncron.v1.model.TiposUsuarios;
import com.sourcesyncron.v1.model.Usuario;
import com.sourcesyncron.v1.model.UsuariosProjetos;
import com.sourcesyncron.v1.repositories.UsuarioProjetosRepository;

@Service
public class UsuariosProjetosService implements Serializable {
	
	/* TODO
	 * -Criar Exceções personalizadas
	 *  */
	

	@Autowired
	UsuarioProjetosRepository repository;
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	ProjetoService projetoService;
	
	@Autowired
	TipoUsuarioService tipoUsuarioService;
	
	private static final long serialVersionUID = 1L;
	
	public UsuariosProjetos create(UsuarioProjetoDTO usuarioProjetoDTO) throws Exception{
		
		Usuario u = usuarioService.findById(usuarioProjetoDTO.getUsuario());
		Projeto p = projetoService.findById(usuarioProjetoDTO.getProjeto());
		TiposUsuarios tu = tipoUsuarioService.findById(usuarioProjetoDTO.getTipoUsuario());
		
		return repository.save(new UsuariosProjetos(tu, u, p));
	}
	
	public List<UsuariosProjetos> findAll(){
		
		return repository.findAll();
	}
	
	public UsuariosProjetos findById(Long id) throws Exception{
		
		return repository.findById(id).orElseThrow(() -> new Exception("Id not found"));
	}
}
