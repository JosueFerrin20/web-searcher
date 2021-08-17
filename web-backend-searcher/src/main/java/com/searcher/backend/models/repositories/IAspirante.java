package com.searcher.backend.models.repositories;

import org.springframework.data.repository.CrudRepository;

import com.searcher.backend.models.entities.Aspirante;

public interface IAspirante extends CrudRepository<Aspirante,Integer> {
	
}
