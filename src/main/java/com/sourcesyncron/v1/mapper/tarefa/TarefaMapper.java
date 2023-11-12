package com.sourcesyncron.v1.mapper.tarefa;

import org.springframework.beans.factory.annotation.Autowired;

import com.sourcesyncron.v1.DTO.tarefa.TarefaResponseDTO;
import com.sourcesyncron.v1.mapper.projeto.ProjetoMapper;
import com.sourcesyncron.v1.model.Tarefa;
import com.sourcesyncron.v1.service.TarefaService;

public class TarefaMapper {

	ProjetoMapper projetoMapper = new ProjetoMapper();
	
	@Autowired
	TarefaService tarefaService;
	
	public TarefaResponseDTO convertModelDTO(Tarefa t) {
		
		TarefaResponseDTO tarefa = new TarefaResponseDTO();
		
		tarefa.setDescricao(t.getDescricao());
		tarefa.setId(t.getId());
		tarefa.setNome(t.getNome());
		tarefa.setProjeto(projetoMapper.convertModelDTO(t.getProjeto()));
		tarefa.setStatus(t.getStatus());
		
		return tarefa;
		
	}

	
	public Tarefa convertDtoModel(TarefaResponseDTO t) throws Exception {
		
		Tarefa tarefa = tarefaService.findById(t.getId());
		
		return tarefa;
		
	}
}
