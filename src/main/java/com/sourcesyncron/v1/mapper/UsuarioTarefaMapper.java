package com.sourcesyncron.v1.mapper;

import com.sourcesyncron.v1.DTO.UsuarioTarefa.UsuarioTarefaResponseDTO;
import com.sourcesyncron.v1.mapper.projeto.ProjetoMapper;
import com.sourcesyncron.v1.mapper.tarefa.TarefaMapper;
import com.sourcesyncron.v1.mapper.usuario.UsuarioMapper;
import com.sourcesyncron.v1.model.UsuarioTarefas;

public class UsuarioTarefaMapper {
	
	
	UsuarioMapper usuarioMapper = new UsuarioMapper();
	ProjetoMapper projetoMapper = new ProjetoMapper();
	TarefaMapper tarefaMapper = new TarefaMapper();
	
	public UsuarioTarefaResponseDTO convertModelDTO(UsuarioTarefas ut) {
		
		UsuarioTarefaResponseDTO utr = new UsuarioTarefaResponseDTO();	
		
		utr.setId(ut.getId());
		utr.setProjeto(projetoMapper.convertModelDTO(ut.getProjeto()));
		utr.setTarefa(tarefaMapper.convertModelDTO(ut.getTarefa()));
		utr.setUsuario(usuarioMapper.convertModelToDto(ut.getUsuario()));
		
		return utr;
	}
}
