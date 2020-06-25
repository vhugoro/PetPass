package br.com.fiap.PetPass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.fiap.PetPass.dto.EstabelecimentoDTO;
import br.com.fiap.PetPass.service.EstabelecimentoService;

@RestController
@RequestMapping("estabelecimentos")
public class EstabelecimentoController {

	@Autowired
	private EstabelecimentoService service;
	
	@GetMapping
	public ResponseEntity<List<EstabelecimentoDTO>> getAll(){
		List<EstabelecimentoDTO> estabelecimentos = this.service.findAll();

		if(estabelecimentos.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(estabelecimentos);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<EstabelecimentoDTO> getById(@PathVariable(value = "id") Long id) {
		EstabelecimentoDTO estabelecimento = this.service.findById(id);
		
		if(estabelecimento != null) {
			return ResponseEntity.ok(estabelecimento);
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/documento")
	public ResponseEntity<EstabelecimentoDTO> getByDocumento(@RequestParam Long documento) {
		EstabelecimentoDTO estabelecimento = this.service.findByDocumento(documento);
		
		if(estabelecimento == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(estabelecimento);
	}
	
	@GetMapping("/nome")
	public ResponseEntity<EstabelecimentoDTO> getByNome(@RequestParam String nome) {
		EstabelecimentoDTO estabelecimento = this.service.findByNome(nome);
		
		if(estabelecimento == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(estabelecimento);
	}
	
	@PostMapping
	public EstabelecimentoDTO create(@RequestBody EstabelecimentoDTO estabelecimento) {
		return this.service.create(estabelecimento);
	}
	
	@PutMapping
	public EstabelecimentoDTO update(@RequestBody EstabelecimentoDTO estabelecimento) {
		return this.service.update(estabelecimento);
	}
	
	@DeleteMapping
	public void delete(@PathVariable Long id) {
		this.service.delete(id);
	}
	
}
