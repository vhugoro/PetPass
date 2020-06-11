package br.com.fiap.PetPass.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.PetPass.converter.ClienteConverter;
import br.com.fiap.PetPass.dto.ClienteDTO;
import br.com.fiap.PetPass.entity.Cliente;
import br.com.fiap.PetPass.repository.ClienteRepository;
import br.com.fiap.PetPass.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ClienteConverter converter;

    private ClienteDTO handleReturnedCliente(Cliente inCliente) {
         ClienteDTO outCliente = null;

        if (inCliente != null) {
            outCliente = converter.toDTO(inCliente);
        }

        return outCliente;
    }

    private List<ClienteDTO> handleReturnedClienteList(List<Cliente> inClientes) {
        List<ClienteDTO> outClientes = null;

        if (!inClientes.isEmpty()) {
            outClientes = converter.toListDTO(inClientes);
        }

        return outClientes;
    }

    private ClienteDTO saveOrUpdate(ClienteDTO inCliente) {
        Cliente save = repository.save(converter.toEntity(inCliente));

        return converter.toDTO(save);
    }

    @Override
    public ClienteDTO find(ClienteDTO inCliente) {
        return this.handleReturnedCliente(repository.findById(inCliente.getId())
                                                    .orElse(null));
    }

    @Override
    public ClienteDTO findByDocumento(Integer inDocumento) {
        return this.handleReturnedCliente(repository.findByDocumento(inDocumento));
    }

    @Override
    public ClienteDTO findByNome(String inNomeCliente) {
        return this.handleReturnedCliente(repository.findByNome(inNomeCliente));
    }

    @Override
    public ClienteDTO findByPlanoId(String inPlanoId) {
        return this.handleReturnedCliente(repository.findByPlanoId(inPlanoId));
    }

    @Override
    public List<ClienteDTO> findAll() {
        return this.handleReturnedClienteList(repository.findAll());
    }

    @Override
    public ClienteDTO create(ClienteDTO inCliente) {
        return this.saveOrUpdate(inCliente);
    }

    @Override
    public ClienteDTO update(ClienteDTO inCliente) {
        return this.saveOrUpdate(inCliente);
    }

    @Override
    public void delete(ClienteDTO inCliente) {
        repository.delete(converter.toEntity(inCliente));
    }

}
