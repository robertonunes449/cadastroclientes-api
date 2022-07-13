package com.roberto.cadastroclientes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roberto.cadastroclientes.domain.Cliente;
import com.roberto.cadastroclientes.repositories.ClienteRepository;
import com.roberto.cadastroclientes.service.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private ColaboradorService colaboradorService;
	
	public Cliente findById(Integer id) {
		
		Optional<Cliente>obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Cliente não encontrado! Id:" + id + ", Tipo: " + Cliente.class.getName()));
	}

	public List<Cliente> findAll(Integer id_col) {
		colaboradorService.findById(id_col);
		return repository.findAllByColaborador(id_col);
	}
}
