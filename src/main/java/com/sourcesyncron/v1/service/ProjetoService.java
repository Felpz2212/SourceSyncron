package com.sourcesyncron.v1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourcesyncron.v1.DTO.projeto.ProjetoCreateDTO;
import com.sourcesyncron.v1.DTO.projeto.ProjetoResponseDTO;
import com.sourcesyncron.v1.mapper.projeto.ProjetoMapper;
import com.sourcesyncron.v1.mapper.usuario.UsuarioMapper;
import com.sourcesyncron.v1.model.Projeto;
import com.sourcesyncron.v1.model.TiposUsuarios;
import com.sourcesyncron.v1.model.Usuario;
import com.sourcesyncron.v1.model.UsuariosProjetos;
import com.sourcesyncron.v1.repositories.ProjetoRepository;
import com.sourcesyncron.v1.repositories.TipoUsuarioRepository;
import com.sourcesyncron.v1.repositories.UsuarioProjetosRepository;
import com.sourcesyncron.v1.repositories.UsuarioRepository;

@Service
public class ProjetoService {
	
	@Autowired
	ProjetoRepository projetoRepository;
	
	@Autowired
	UsuarioProjetosRepository usuarioProjetoRepository;
	
	@Autowired
	TipoUsuarioRepository tipoUsuarioRepository;

	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	ProjetoMapper projetoMapper = new ProjetoMapper();
	UsuarioMapper usuarioMapper = new UsuarioMapper();
	
	public List<Projeto> findAllProjetos(){
		
		return projetoRepository.findAll();
	}
	
	public ProjetoResponseDTO findById(Long id) throws Exception{
		
		return projetoMapper.convertModelDTO(projetoRepository.findById(id).get());
	}
	
	public ProjetoResponseDTO create(ProjetoCreateDTO projeto) throws Exception {
		
		Usuario u = usuarioRepository.findById(projeto.getOwner()).get();
		
		Projeto p = projetoRepository.save(new Projeto(projeto.getNome(), projeto.getDescricao(),
				true, u, projeto.getGithub_link()));
		
		UsuariosProjetos up = new UsuariosProjetos();
		TiposUsuarios tu = tipoUsuarioRepository.findById(1L).get();
		
		up.setUsuario(p.getOwner());
		up.setProjeto(p);
		up.setTipoUsuario(tu);
		
		System.out.println(up.getId());
		
		usuarioProjetoRepository.save(up);
		
		return projetoMapper.convertModelDTO(p);
	}

}
