package com.andreia.osworks.api.controller;


import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.andreia.osworks.domain.model.Cliente;
import com.andreia.osworks.domain.repository.ClienteRepository;
import com.andreia.osworks.domain.service.CadastroClienteService;


@RestController
public class ClienteController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private CadastroClienteService cadastroCliente;
	
	@GetMapping("/cliente")
	public List<Cliente> listar() {
		return clienteRepository.findAll();
		//return clienteRepository.findByNome("Carlos Roberto");
		//return clienteRepository.findByNomeContaining("An");
		
		
		/*var cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("Andreia");
		cliente1.setEmail("andreia.net@gmail.com");
		cliente1.setTelefone("14 99877-9877");
		
		var cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setNome("Rosa");
		cliente2.setEmail("rosa.net@gmail.com");
		cliente2.setTelefone("14 7789-9877");
		
		return Arrays.asList(cliente1, cliente2);*/
	}
	
	@GetMapping("clientes/{clienteId}")
	public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId) {
		Optional<Cliente> cliente = clienteRepository.findById(clienteId);
		if (cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		}
		return ResponseEntity.notFound().build(); 
	}
	
	@PostMapping
	@RequestMapping(method = RequestMethod.POST, value ="/clientes")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@Valid @RequestBody Cliente cliente) {
		return cadastroCliente.salvar(cliente);
	}
	
	@PutMapping("/{clienteId}")
	@RequestMapping(method = RequestMethod.PUT, value ="/clientes/{clienteId}")
	public ResponseEntity<Cliente> atualizar (@Valid @PathVariable Long clienteId,@RequestBody Cliente cliente){
		
		if (!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		cliente.setId(clienteId);
		cliente = cadastroCliente.salvar(cliente);
		
		return ResponseEntity.ok(cliente);
	}
	
	@DeleteMapping("/{clienteId}")
	//Erro:Request method 'DELETE' not supported - Deve ser resolvido com a linha abaixo
	@RequestMapping(method = RequestMethod.DELETE, value ="/clientes/{clienteId}") 
	public ResponseEntity<Void>remover(@PathVariable Long clienteId){
		if (!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		cadastroCliente.excluir(clienteId);
		return ResponseEntity.noContent().build();
	}

}
