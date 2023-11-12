package com.sourcesyncron.v1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourcesyncron.v1.DTO.UsuarioTarefa.UsuarioTarefaCreateDTO;
import com.sourcesyncron.v1.DTO.UsuarioTarefa.UsuarioTarefaResponseDTO;
import com.sourcesyncron.v1.mapper.UsuarioTarefaMapper;
import com.sourcesyncron.v1.mapper.usuario.UsuarioMapper;
import com.sourcesyncron.v1.model.Tarefa;
import com.sourcesyncron.v1.model.Usuario;
import com.sourcesyncron.v1.model.UsuarioTarefas;
import com.sourcesyncron.v1.repositories.UsuarioRepository;
import com.sourcesyncron.v1.repositories.UsuarioTarefaRepository;

@Service
public class UsuarioTarefaService {
	
	@Autowired
	UsuarioTarefaRepository usuarioTarefaRepository;
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	TarefaService tarefaService;
	
	@Autowired
	UsuarioRepository usuarioRepo;
	

	UsuarioMapper usuarioMapper = new UsuarioMapper();	
	UsuarioTarefaMapper usuarioTarefaMapper = new UsuarioTarefaMapper();
	
	public UsuarioTarefas createUsuarioTarefa(UsuarioTarefaCreateDTO usuarioTarefaDTO) throws Exception {
		
		Tarefa t = tarefaService.findById(usuarioTarefaDTO.getTarefa());
		Usuario u = usuarioRepo.findById(usuarioTarefaDTO.getUsuario()).get();
		
		UsuarioTarefas ut = new UsuarioTarefas(t.getProjeto(), t, u);
		
		return usuarioTarefaRepository.save(ut);
	}
	
	public List<UsuarioTarefas> getUsuariosTarefasByUser(Long id) throws Exception{
		
		return usuarioTarefaRepository.findAllByUsuario(id);
	}
	
	public List<UsuarioTarefaResponseDTO> getUsuariosTarefasByProjectAndUser(Long id_usuario, Long id_projeto) throws Exception{
		
		List<UsuarioTarefaResponseDTO> tarefas = new ArrayList<>();
		
		List<UsuarioTarefas> tarefas_bd = new ArrayList<>();
		
		tarefas_bd = usuarioTarefaRepository.findTarefasProjetoByUser(id_usuario, id_projeto);
		
		for (UsuarioTarefas u : tarefas_bd) {
			
			tarefas.add(usuarioTarefaMapper.convertModelDTO(u));
		}
		
		return tarefas;
	}
}
