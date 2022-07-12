package com.roberto.cadastroclientes.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roberto.cadastroclientes.domain.Colaborador;
import com.roberto.cadastroclientes.dtos.ColaboradorDTO;
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
	
	@GetMapping
	public ResponseEntity<List<ColaboradorDTO>> findAll() {
		List<Colaborador> list = service.findAll();
		List<ColaboradorDTO> listDTO = list.stream().map(obj -> new ColaboradorDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
}

//localhost:8080/colaborador/1
