package br.com.fiap.PetPass.service;

import br.com.fiap.PetPass.dto.ClienteDTO;
import br.com.fiap.PetPass.enums.PlanoEnum;

import java.util.List;

public interface ClienteService {

    ClienteDTO findByDocumento(Integer documento);

    ClienteDTO findByNome(String nome);

    List<ClienteDTO> findByPlano(PlanoEnum plano);

    ClienteDTO findById(Long id);

    List<ClienteDTO> findAll();

    ClienteDTO create(ClienteDTO clienteDTO);

    ClienteDTO update(ClienteDTO clienteDTO);

    void delete(ClienteDTO clienteDTO);

    void geraCobranca(ClienteDTO clienteDTO);

}
