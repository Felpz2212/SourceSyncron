package com.sourcesyncron.v1.mapper;

import com.sourcesyncron.v1.DTO.UsuarioProjeto.UsuarioProjetoResponseDTO;
import com.sourcesyncron.v1.mapper.projeto.ProjetoMapper;
import com.sourcesyncron.v1.mapper.usuario.UsuarioMapper;
import com.sourcesyncron.v1.model.UsuariosProjetos;

public class UsuarioProjetoMapper {

	UsuarioMapper usuarioMapper = new UsuarioMapper();
	ProjetoMapper projetoMapper = new ProjetoMapper();
	
	public UsuarioProjetoResponseDTO convertModelDTO(UsuariosProjetos pu) {
		UsuarioProjetoResponseDTO up = new UsuarioProjetoResponseDTO();	
		
		up.setId(pu.getId());
		up.setProjeto(projetoMapper.convertModelDTO(pu.getProjeto()));
		up.setTipo(pu.getTipoUsuario());
		up.setUsuario(usuarioMapper.convertModelToDto(pu.getUsuario()));
		
		return up;
	}
	
	
	public UsuariosProjetos convertDtoModel(UsuarioProjetoResponseDTO up) throws Exception {
		
		UsuariosProjetos pu = new UsuariosProjetos();
		
		pu.setId(up.getId());
		pu.setProjeto(projetoMapper.convertDtoModel(up.getProjeto()));
		pu.setTipoUsuario(up.getTipo());
		pu.setUsuario(usuarioMapper.convertDtoToModel(up.getUsuario()));
		
		return pu;
		
	}
}
