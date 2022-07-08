package com.roberto.cadastroclientes;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.roberto.cadastroclientes.domain.Cliente;
import com.roberto.cadastroclientes.domain.Colaborador;
import com.roberto.cadastroclientes.repositories.ClienteRepository;
import com.roberto.cadastroclientes.repositories.ColaboradorRepository;

@SpringBootApplication
public class CadastroclientesApplication implements CommandLineRunner {

	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CadastroclientesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Colaborador col1 = new Colaborador(null, "João", "João", "João", "João", "João", "João", "João", "João", "João", "João", "João", "João", "João");
		
		Cliente c1 = new Cliente(null, "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", "Jose", col1);
		
		col1.getClientes().addAll(Arrays.asList(c1));
		
		this.colaboradorRepository.saveAll(Arrays.asList(col1));
		this.clienteRepository.saveAll(Arrays.asList(c1));
	}

}
