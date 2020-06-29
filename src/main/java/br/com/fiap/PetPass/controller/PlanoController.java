package br.com.fiap.PetPass.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.PetPass.dto.PlanoDTO;
import br.com.fiap.PetPass.service.PlanoService;

@RestController
@RequestMapping("planos")
public class PlanoController {

	@Autowired
	private PlanoService service;
	
	@GetMapping
	public ResponseEntity<List<PlanoDTO>> getAll() {
		List<PlanoDTO> planos = service.findAll();
		
		if(planos.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(planos);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<PlanoDTO> getById(@PathVariable Long id) {
		PlanoDTO plano = service.findById(id);
		
		if(plano == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(plano);
	}
	
	@PostMapping
	public ResponseEntity<PlanoDTO> create(@RequestBody PlanoDTO planoDTO) {
		PlanoDTO plano = service.create(planoDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(plano);
	}
	
	@PutMapping
	public PlanoDTO update(@RequestBody PlanoDTO planoDTO) {
		return service.update(planoDTO);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		PlanoDTO planoDTO = service.findById(id);
		
		if(planoDTO == null) {
			return ResponseEntity.notFound().build();
		}
		
		service.delete(planoDTO);
		return ResponseEntity.ok(id);
		
	}	
}