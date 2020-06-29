package br.com.fiap.PetPass.service;

import java.util.List;

import br.com.fiap.PetPass.dto.PlanoDTO;

public interface PlanoService {

	PlanoDTO findByNome(String nome);
    
	PlanoDTO findById(Long id);

    List<PlanoDTO> findAll();

    PlanoDTO create(PlanoDTO planoDTO);

    PlanoDTO update(PlanoDTO planoDTO);

    void delete(PlanoDTO clienteDTO);
}