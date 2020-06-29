package br.com.fiap.PetPass.service;

import br.com.fiap.PetPass.dto.PlanoDTO;

import java.util.List;

public interface PlanoService {

    PlanoDTO findByNome(String nome);

    PlanoDTO findById(Long id);

    List<PlanoDTO> findAll();

    PlanoDTO create(PlanoDTO planoDTO);

    PlanoDTO update(PlanoDTO planoDTO);

    void delete(PlanoDTO clienteDTO);
}