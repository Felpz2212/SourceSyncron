package com.sourcesyncron.v1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourcesyncron.v1.DTO.projeto.ProjetoResponseDTO;
import com.sourcesyncron.v1.DTO.tarefa.TarefaCreateDTO;
import com.sourcesyncron.v1.mapper.projeto.ProjetoMapper;
import com.sourcesyncron.v1.model.Projeto;
import com.sourcesyncron.v1.model.Status;
import com.sourcesyncron.v1.model.Tarefa;
import com.sourcesyncron.v1.repositories.ProjetoRepository;
import com.sourcesyncron.v1.repositories.TarefaRepository;

@Service
public class TarefaService {
	
	@Autowired
	TarefaRepository tarefaRepository;
	
	@Autowired
	ProjetoService projetoService;
	
	@Autowired
	ProjetoRepository projetoRepo;
	
	@Autowired
	StatusService statusService;
	
	ProjetoMapper projetoMapper = new ProjetoMapper();
	
	public List<Tarefa> findAll(){
		return tarefaRepository.findAll();
	}
	
	public Tarefa findById(Long id) throws Exception {
		return tarefaRepository.findById(id).orElseThrow(() -> new Exception("Tarefa nao encontrada"));
	}
	
	public Tarefa create(TarefaCreateDTO t) throws Exception {
		
		Tarefa tarefa = new Tarefa();
		Projeto projeto = projetoRepo.findById(t.getProjeto_id()).get();
		
		tarefa.setData_final(t.getData_final());
		tarefa.setData_inicio(t.getData_inicial());
		tarefa.setDescricao(t.getDescricao());
		tarefa.setDuracao_estimada(t.getDuracao());
		tarefa.setNome(t.getNome());
		tarefa.setProjeto(projeto);
		tarefa.setPublico(true);

		return tarefaRepository.save(tarefa);
	}

	
	public Tarefa update(TarefaCreateDTO t) throws Exception {
		
		Tarefa tarefa = tarefaRepository.findById(t.getId()).get();
		Status status = statusService.findOne(t.getStatus_id());
		ProjetoResponseDTO projeto = projetoService.findById(t.getProjeto_id());
		
		tarefa.setNome(t.getNome());
		tarefa.setDescricao(t.getDescricao());
		tarefa.setData_inicio(t.getData_inicial());
		tarefa.setData_final(t.getData_final());
		tarefa.setDuracao_estimada(t.getDuracao());
		tarefa.setStatus(status);
		tarefa.setProjeto(projetoMapper.convertDtoModel(projeto));
		
		
		
		
		return tarefaRepository.save(tarefa);
	}

}
