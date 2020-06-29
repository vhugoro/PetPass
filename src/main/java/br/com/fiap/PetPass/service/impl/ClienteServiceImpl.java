package br.com.fiap.PetPass.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.PetPass.converter.ClienteConverter;
import br.com.fiap.PetPass.dto.ClienteDTO;
import br.com.fiap.PetPass.entity.Cliente;
import br.com.fiap.PetPass.enums.PlanoEnum;
import br.com.fiap.PetPass.repository.ClienteRepository;
import br.com.fiap.PetPass.service.ClienteService;
import br.com.fiap.PetPass.utils.MessageRabbit;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ClienteConverter converter;

    @Override
    public ClienteDTO findByDocumento(Integer documento) {
        return this.converter.toDTO(repository.findByDocumento(documento));
    }

    @Override
    public ClienteDTO findByNome(String nome) {
        return this.converter.toDTO(repository.findByNome(nome));
    }

    @Override
    public List<ClienteDTO> findByPlano(PlanoEnum plano) {
        return this.converter.toListDTO(repository.findAllByPlano(plano));
    }

    @Override
    public List<ClienteDTO> findAll() {
        return this.converter.toListDTO(repository.findAll());
    }
    
    @Override
    public ClienteDTO findById(Long id) {
    	return converter.toDTO(repository.findById(id).orElse(null));
    }

    @Override
    public ClienteDTO create(ClienteDTO clienteDTO) {
    	Cliente cliente = this.repository.save(converter.toEntity(clienteDTO));
        return this.converter.toDTO(cliente);
    }

    @Override
    public ClienteDTO update(ClienteDTO clienteDTO) {
    	Cliente cliente = this.repository.save(this.converter.toEntity(clienteDTO));
        return this.converter.toDTO(cliente);
    }

    @Override
    public void delete(ClienteDTO clienteDTO) {
        repository.delete(converter.toEntity(clienteDTO));
    }

    @Override
    public void geraCobranca(ClienteDTO clienteDTO) {
    	MessageRabbit message = new MessageRabbit();
    	message.geraCobranca(clienteDTO);
    }
}
