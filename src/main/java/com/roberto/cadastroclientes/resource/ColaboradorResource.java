package com.roberto.cadastroclientes.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roberto.cadastroclientes.domain.Colaborador;
import com.roberto.cadastroclientes.service.ColaboradorService;

@RestController
@RequestMapping(value = "/colaborador")
public class ColaboradorResource {
	
	@Autowired
	private ColaboradorService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Colaborador> findById(@PathVariable Integer id) {
		Colaborador obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}

//localhost:8080/colaborador/1
