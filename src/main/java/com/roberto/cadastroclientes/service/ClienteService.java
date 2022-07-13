package com.roberto.cadastroclientes.service;

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
	
	public Cliente findById(Integer id) {
		
		Optional<Cliente>obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Cliente não encontrado! Id:" + id + ", Tipo: " + Cliente.class.getName()));
	}
}
