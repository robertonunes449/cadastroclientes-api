package com.roberto.cadastroclientes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.roberto.cadastroclientes.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	@Query("SELECT obj FROM  Cliente obj  WHERE obj.colaborador.id = :id_col ORDER BY nome")
	List<Cliente> findAllByColaborador(@Param(value = "id_col") Integer id_col);

	

}
