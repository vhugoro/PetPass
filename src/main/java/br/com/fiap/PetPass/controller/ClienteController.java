package br.com.fiap.PetPass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.PetPass.dto.ClienteDTO;
import br.com.fiap.PetPass.service.ClienteService;

@RestController
@RequestMapping("clientes")
public class ClienteController {

	@Autowired
	private ClienteService service;
	
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> getAll() {
		List<ClienteDTO> clientes = service.findAll();
		
		if(clientes.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(clientes);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ClienteDTO> getById(@PathVariable Long id) {
		ClienteDTO cliente = service.findById(id);
		
		if(cliente == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(cliente);
	}
	
	@GetMapping("/documento")
	public ResponseEntity<ClienteDTO> getByDocumento(@RequestParam Integer documento) {
		ClienteDTO cliente = service.findByDocumento(documento);
		
		if(cliente == null) {
			return ResponseEntity.notFound().build();
		}
				
		return ResponseEntity.ok(cliente); 
	}
	
	@PostMapping
	public ResponseEntity<ClienteDTO> create(@RequestBody ClienteDTO clienteDTO) {
		ClienteDTO cliente = service.create(clienteDTO);
		return ResponseEntity.ok(cliente);
	}
	
	@PutMapping
	public ClienteDTO update(@RequestBody ClienteDTO clienteDTO) {
		return service.update(clienteDTO);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		ClienteDTO clienteDTO = service.findById(id);
		
		if(clienteDTO == null) {
			return ResponseEntity.notFound().build();
		}
		
		service.delete(clienteDTO);
		return ResponseEntity.ok(id);
		
	}
	
}
