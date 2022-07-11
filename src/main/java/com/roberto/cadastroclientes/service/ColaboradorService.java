package com.roberto.cadastroclientes.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roberto.cadastroclientes.domain.Colaborador;
import com.roberto.cadastroclientes.repositories.ColaboradorRepository;
import com.roberto.cadastroclientes.service.exceptions.ObjectNotFoundException;

@Service
public class ColaboradorService {

	@Autowired
	private ColaboradorRepository repository;

	public Colaborador findById(Integer id) {
		Optional<Colaborador> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id + ",Tipo:" + Colaborador.class.getName()));

	}
}
