package br.com.fiap.PetPass.service;

import java.util.List;

import br.com.fiap.PetPass.dto.ClienteDTO;

public interface ClienteService {

    ClienteDTO find(ClienteDTO inCliente);

    ClienteDTO findByDocumento(Integer inDocumento);

    ClienteDTO findByNome(String inNomeCliente);
    
    ClienteDTO findByPlanoId(String inPlanoId);

    List<ClienteDTO> findAll();

    ClienteDTO create(ClienteDTO inCliente);

    ClienteDTO update(ClienteDTO inCliente);

    void delete(ClienteDTO inCliente);

}
