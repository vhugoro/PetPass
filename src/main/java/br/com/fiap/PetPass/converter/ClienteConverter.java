package br.com.fiap.PetPass.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.fiap.PetPass.dto.ClienteDTO;
import br.com.fiap.PetPass.entity.Cliente;

@Service
public class ClienteConverter {

    public ClienteDTO toDTO(Cliente inCliente) {
    	if(inCliente == null) {
    		return null;
    	}    	
    	
        return new ClienteDTO(inCliente);
    }

    public List<ClienteDTO> toListDTO(List<Cliente> inClientes) {
    	List<ClienteDTO> clientes = new ArrayList();
    	
    	if(!inClientes.isEmpty()) {
    		clientes.addAll(inClientes.stream()
                    .map(this::toDTO)
                    .collect(Collectors.toList()));
    	}
    	
    	
        return clientes;
    }

    public Cliente toEntity(ClienteDTO inCliente) {
    	
    	if(inCliente == null) {
    		return null;
    	}
    	
        Cliente cliente = new Cliente();

        cliente.setId(inCliente.getId());
        cliente.setNome(inCliente.getNome());
        cliente.setDocumento(inCliente.getDocumento());
        cliente.setPlano(inCliente.getPlano());

        return cliente;
    }

    public List<Cliente> toListEntity(List<ClienteDTO> inClientes) {
    	List<Cliente> clientes = new ArrayList();
    	
    	if(!inClientes.isEmpty()) {
    		clientes.addAll(inClientes.stream()
                    .map(this::toEntity)
                    .collect(Collectors.toList()));
    	}
    	
        return clientes;
    }

}
