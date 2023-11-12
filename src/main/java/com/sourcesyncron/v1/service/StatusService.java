package com.sourcesyncron.v1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourcesyncron.v1.model.Status;
import com.sourcesyncron.v1.repositories.StatusRepository;

@Service
public class StatusService {

	@Autowired
	StatusRepository repository;
	
	
	public Status findOne(Long id) {
		
		return repository.findById(id).get();
	}
}
