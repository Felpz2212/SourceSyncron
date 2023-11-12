package com.sourcesyncron.v1.mapper.projeto;

import org.springframework.beans.factory.annotation.Autowired;

import com.sourcesyncron.v1.DTO.projeto.ProjetoResponseDTO;
import com.sourcesyncron.v1.DTO.usuario.UsuarioDTO;
import com.sourcesyncron.v1.mapper.usuario.UsuarioMapper;
import com.sourcesyncron.v1.model.Projeto;
import com.sourcesyncron.v1.model.Usuario;
import com.sourcesyncron.v1.repositories.UsuarioRepository;
import com.sourcesyncron.v1.service.ProjetoService;

public class ProjetoMapper {
	

	UsuarioMapper usuarioMapper = new UsuarioMapper();
	
	@Autowired
	UsuarioRepository userRepo;
	
	@Autowired
	ProjetoService projetoService;
	
	public ProjetoResponseDTO convertModelDTO(Projeto p) {
		
		ProjetoResponseDTO pr = new ProjetoResponseDTO();
		
		Usuario u = p.getOwner();
		UsuarioDTO user = usuarioMapper.convertModelToDto(u);
		
		pr.setNome(p.getNome());
		pr.setId(p.getId());
		pr.setDescricao(p.getDescricao());
		pr.setUsuario(user);
		pr.setGithub_link(p.getGithub_link());
		
		return pr;
	}
	
	public Projeto convertDtoModel(ProjetoResponseDTO p) throws Exception {
		
		ProjetoResponseDTO projeto = projetoService.findById(p.getId());
		
		UsuarioDTO user = projeto.getUsuario();
		
		Usuario u = userRepo.findById(user.getId()).get();
		
		Projeto pr = new Projeto(projeto.getId(), projeto.getNome(), projeto.getDescricao(),
				true, u, projeto.getGithub_link());
		
		return pr;
	}
}
