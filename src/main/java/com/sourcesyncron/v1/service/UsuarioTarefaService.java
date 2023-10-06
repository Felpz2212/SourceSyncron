package com.sourcesyncron.v1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourcesyncron.v1.DTO.UsuarioTarefaDTO;
import com.sourcesyncron.v1.model.Tarefa;
import com.sourcesyncron.v1.model.Usuario;
import com.sourcesyncron.v1.model.UsuarioTarefas;
import com.sourcesyncron.v1.repositories.UsuarioTarefaRepository;

@Service
public class UsuarioTarefaService {
	
	@Autowired
	UsuarioTarefaRepository usuarioTarefaRepository;
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	TarefaService tarefaService;
	
	public UsuarioTarefas createUsuarioTarefa(UsuarioTarefaDTO usuarioTarefaDTO) throws Exception {
		
		Tarefa t = tarefaService.findById(usuarioTarefaDTO.getTarefa());
		Usuario u = usuarioService.findById(usuarioTarefaDTO.getUsuario());
		
		UsuarioTarefas ut = new UsuarioTarefas(t.getProjeto(), t, u);
		
		return usuarioTarefaRepository.save(ut);
	}
}
