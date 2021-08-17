package com.searcher.backend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.searcher.backend.models.entities.Entidad;
import web.searcher.backend.models.services.interfaces.IEntidadService;

@RestController
@RequestMapping("/entidad")
public class EntidadController {

	@Autowired
	IEntidadService service;
		
	//CRUD
	//Create
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody Entidad e ) {
		try {
			service.save(e);
			return ResponseEntity.status(HttpStatus.CREATED).body(e);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	
	//Retrieve
	@GetMapping("/retrieve/{id}")
	public ResponseEntity<?> retrieve(@PathVariable Integer id) {
		try {
			Optional<Entidad> e = service.findById(id);
			if(e.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entidad no encontrada");
			}
			return ResponseEntity.ok(e);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}		
	}
	
	//Update
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Entidad e) {
		try {
			e.setIdEntidad(id);
			service.save(e);
			return ResponseEntity.ok(e);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id) {
		try {
			Optional<Entidad> e = service.findById(id);
			if(e.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entidad no encontrada");
			}
			service.delete(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(e);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> list() {
		try {
			List<Entidad> Entidades = service.findAll();
			if(Entidades.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay Entidades registradas");
			}
			return ResponseEntity.ok(Entidades);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}		
	}
}
