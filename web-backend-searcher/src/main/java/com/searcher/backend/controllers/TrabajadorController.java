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

import com.searcher.backend.models.entities.Trabajador;

import web.searcher.backend.models.services.interfaces.ITrabajadorService;

@RestController
@RequestMapping("/trabajador")
public class TrabajadorController {

	@Autowired
	ITrabajadorService service;
		
	//CRUD
	//Create
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody Trabajador t ) {
		try {
			service.save(t);
			return ResponseEntity.status(HttpStatus.CREATED).body(t);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	
	//Retrieve
	@GetMapping("/retrieve/{id}")
	public ResponseEntity<?> retrieve(@PathVariable Integer id) {
		try {
			Optional<Trabajador> t = service.findById(id);
			if(t.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Trabajador no encontrado");
			}
			return ResponseEntity.ok(t);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}		
	}
	
	//Update
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Trabajador t) {
		try {
			t.setIdTrabajador(id);
			service.save(t);
			return ResponseEntity.ok(t);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id) {
		try {
			Optional<Trabajador> t = service.findById(id);
			if(t.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Trabajador no encontrado");
			}
			service.delete(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(t);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> list() {
		try {
			List<Trabajador> trabajadores = service.findAll();
			if(trabajadores.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay Trabajadores registrados");
			}
			return ResponseEntity.ok(trabajadores);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}		
	}
}
