package com.searcher.backend.models.repositories;

import org.springframework.data.repository.CrudRepository;

import com.searcher.backend.models.entities.Curso;

public interface ICurso extends CrudRepository<Curso,Integer> {

}
