package com.roberto.cadastroclientes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roberto.cadastroclientes.domain.Cliente;
import com.roberto.cadastroclientes.domain.Colaborador;
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

	public Cliente update(Integer id, Cliente obj) {
		Cliente newObj = findById(id);
		updateData(newObj, obj);
		return repository.save(newObj);
	}

	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
		newObj.setNascimento(obj.getNascimento());
		newObj.setProfissao(obj.getProfissao());
		newObj.setCalcado(obj.getCalcado());
		newObj.setLogradouro(obj.getLogradouro());
		newObj.setNumero(obj.getNumero());
		newObj.setComplemento(obj.getComplemento());
		newObj.setCep(obj.getCep());
		newObj.setBairro(obj.getBairro());
		newObj.setCidade(obj.getCidade());
		newObj.setUf(obj.getUf());
		newObj.setTelefone(obj.getTelefone());
		newObj.setCelular(obj.getCelular());
		newObj.setContato(obj.getContato());
	}

	public Cliente create(Integer id_col, Cliente obj) {
		obj.setId(null);
		Colaborador col = colaboradorService.findById(id_col);
		obj.setColaborador(col);
		return repository.save(obj);
	}

	public void delete(Integer id) {
		Cliente obj = findById(id);
		repository.delete(obj);
	}
}
