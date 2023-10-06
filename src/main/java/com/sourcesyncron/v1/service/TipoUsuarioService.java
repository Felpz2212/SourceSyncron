package com.sourcesyncron.v1.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourcesyncron.v1.model.TiposUsuarios;
import com.sourcesyncron.v1.repositories.TipoUsuarioRepository;

@Service
public class TipoUsuarioService implements Serializable{

	@Autowired
	TipoUsuarioRepository tipoUsuarioRepository;
	
	private static final long serialVersionUID = 1L;
	
	public TiposUsuarios findById(Long id) throws Exception{
		
		return tipoUsuarioRepository.findById(id).orElseThrow(() -> new Exception("id not found"));
	}

}
