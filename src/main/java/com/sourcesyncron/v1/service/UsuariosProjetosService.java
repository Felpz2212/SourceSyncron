package com.sourcesyncron.v1.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourcesyncron.v1.DTO.UsuarioProjeto.UsuarioProjetoDTO;
import com.sourcesyncron.v1.DTO.UsuarioProjeto.UsuarioProjetoResponseDTO;
import com.sourcesyncron.v1.mapper.UsuarioProjetoMapper;
import com.sourcesyncron.v1.mapper.projeto.ProjetoMapper;
import com.sourcesyncron.v1.mapper.usuario.UsuarioMapper;
import com.sourcesyncron.v1.model.Projeto;
import com.sourcesyncron.v1.model.TiposUsuarios;
import com.sourcesyncron.v1.model.Usuario;
import com.sourcesyncron.v1.model.UsuariosProjetos;
import com.sourcesyncron.v1.repositories.ProjetoRepository;
import com.sourcesyncron.v1.repositories.UsuarioProjetosRepository;
import com.sourcesyncron.v1.repositories.UsuarioRepository;

@Service
public class UsuariosProjetosService implements Serializable {

	@Autowired
	UsuarioProjetosRepository repository;
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	ProjetoService projetoService;
	
	@Autowired
	TipoUsuarioService tipoUsuarioService;
	
	@Autowired
	ProjetoRepository projetoRepo;
	
	@Autowired
	UsuarioRepository userRepo;
	
	
	UsuarioMapper usuarioMapper = new UsuarioMapper();
	UsuarioProjetoMapper mapper = new UsuarioProjetoMapper();
	ProjetoMapper projetoMapper = new ProjetoMapper();
	
	private static final long serialVersionUID = 1L;
	
	public UsuariosProjetos create(UsuarioProjetoDTO usuarioProjetoDTO) throws Exception{
		
		Usuario u = userRepo.findById(usuarioProjetoDTO.getUsuario()).get();
		Projeto p = projetoRepo.findById(usuarioProjetoDTO.getProjeto()).get();
		TiposUsuarios tu = tipoUsuarioService.findById(usuarioProjetoDTO.getTipoUsuario());
		
		return repository.save(new UsuariosProjetos(tu, u, p));
	}
	
	public List<UsuariosProjetos> findAll(){
		
		return repository.findAll();
	}
	
	public UsuariosProjetos findById(Long id) throws Exception{
		
		return repository.findById(id).orElseThrow(() -> new Exception("Id not found"));
	}
	
	public List<UsuarioProjetoResponseDTO> findByUsuario(Long id) throws Exception{
	
		List<UsuarioProjetoResponseDTO> projetos = new ArrayList<>();
		
		List<UsuariosProjetos> listBD = new ArrayList<>();
		listBD = repository.findAllByUsuario(id);
		
		for (UsuariosProjetos usuarioProjetoResponseDTO : listBD) {
			projetos.add(mapper.convertModelDTO(usuarioProjetoResponseDTO));
		}
		
		return projetos;
	}

	public List<UsuarioProjetoResponseDTO> findUsersByProject(Long id){
		
		List<UsuarioProjetoResponseDTO> projetos = new ArrayList<>();
		
		List<UsuariosProjetos> listBD = new ArrayList<>();
		listBD = repository.findAllUsersByProject(id);
		
		for (UsuariosProjetos usuarioProjetoResponseDTO : listBD) {
			projetos.add(mapper.convertModelDTO(usuarioProjetoResponseDTO));
		}
		
		return projetos;
	}
}
