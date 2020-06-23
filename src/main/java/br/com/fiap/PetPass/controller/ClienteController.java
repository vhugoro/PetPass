package br.com.fiap.PetPass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<ClienteDTO> getAll() {
		return service.findAll();
	}
	
	@GetMapping("{id}")
	public ClienteDTO getById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@GetMapping("/documento")
	public ClienteDTO getByDocumento(@RequestParam Integer documento) {
		return service.findByDocumento(documento);
	}
	
	@PostMapping
	public ClienteDTO create(@RequestBody ClienteDTO clienteDTO) {
		return service.create(clienteDTO);
	}
	
	@PutMapping
	public ClienteDTO update(@RequestBody ClienteDTO clienteDTO) {
		return service.update(clienteDTO);
	}
	
	@DeleteMapping
	public void delete(@PathVariable Long id) {
		ClienteDTO clienteDTO = service.findById(id);
		service.delete(clienteDTO);
	}
	
}
