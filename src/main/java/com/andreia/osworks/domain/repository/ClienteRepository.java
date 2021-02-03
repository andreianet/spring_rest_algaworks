package com.andreia.osworks.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andreia.osworks.domain.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	List<Cliente>findByNome(String nome); //para buscar por nome
	List<Cliente>findByNomeContaining(String nome); //buscar por caracteres
	Cliente findByEmail(String Email);
	
	
}
