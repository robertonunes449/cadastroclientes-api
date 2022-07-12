package com.roberto.cadastroclientes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roberto.cadastroclientes.domain.Colaborador;
import com.roberto.cadastroclientes.dtos.ColaboradorDTO;
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
	
	public List<Colaborador> findAll() {
		return repository.findAll();
	}
	
	public Colaborador create(Colaborador obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Colaborador update(Integer id, ColaboradorDTO objDto) {
		Colaborador obj = findById(id);
		obj.setNome(objDto.getNome());
		obj.setEmail(objDto.getEmail());
		obj.setNascimento(objDto.getNascimento());
		obj.setFuncao(objDto.getFuncao());
		obj.setLogradouro(objDto.getLogradouro());
		obj.setNumero(objDto.getNumero());
		obj.setComplemento(objDto.getComplemento());
		obj.setCep(objDto.getCep());
		obj.setBairro(objDto.getBairro());
		obj.setCidade(objDto.getCidade());
		obj.setUf(objDto.getUf());
		obj.setTelefone(objDto.getTelefone());
		obj.setCelular(objDto.getCelular());
		return repository.save(obj);
	}
}
