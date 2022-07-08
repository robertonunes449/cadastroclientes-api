package com.roberto.cadastroclientes.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roberto.cadastroclientes.domain.Cliente;
import com.roberto.cadastroclientes.domain.Colaborador;
import com.roberto.cadastroclientes.repositories.ClienteRepository;
import com.roberto.cadastroclientes.repositories.ColaboradorRepository;

@Service
public class DBService {

	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;

	public void instanciaBaseDeDAdos() {
		
		Colaborador col1 = new Colaborador(null, "João", "João", "João", "João", "João", "João", "João", "João", "João", "João", "João", "João", "João");
		Colaborador col2 = new Colaborador(null, "João", "João", "João", "João", "João", "João", "João", "João", "João", "João", "João", "João", "João");
		Colaborador col3 = new Colaborador(null, "João", "João", "João", "João", "João", "João", "João", "João", "João", "João", "João", "João", "João");
		
		
		Cliente c1 = new Cliente(null, "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", col1);
		Cliente c2 = new Cliente(null, "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", col2);
		Cliente c3 = new Cliente(null, "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", col2);
		Cliente c4 = new Cliente(null, "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", col2);
		Cliente c5 = new Cliente(null, "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", col3);
		
		col1.getClientes().addAll(Arrays.asList(c1));
		col2.getClientes().addAll(Arrays.asList(c2, c3, c4));
		col3.getClientes().addAll(Arrays.asList(c5));
		
		this.colaboradorRepository.saveAll(Arrays.asList(col1, col2, col3));
		this.clienteRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5));
	}
}
