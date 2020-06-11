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

import br.com.fiap.PetPass.dto.EstabelecimentoDTO;
import br.com.fiap.PetPass.service.EstabelecimentoService;

@RestController
@RequestMapping("estabelecimentos")
public class EstabelecimentoController {

	@Autowired
	private EstabelecimentoService service;
	
	@GetMapping
	public List<EstabelecimentoDTO> getAll(){
		return this.service.findAll();
	}
	
	@GetMapping("{id}")
	public EstabelecimentoDTO getById(@PathVariable(value = "id") Long id) {
		return this.service.findById(id);
	}
	
	@GetMapping
	public EstabelecimentoDTO getByDocumento(@RequestParam Integer documento) {
		return this.service.findByDocumento(documento);
	}
	
	@GetMapping
	public EstabelecimentoDTO getByNome(@RequestParam String nome) {
		return this.service.findByNome(nome);
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
