package br.com.fiap.PetPass.controller;

import java.io.IOException;
import java.time.LocalDateTime;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.PetPass.dto.ClienteDTO;
import br.com.fiap.PetPass.service.ClienteService;
import br.com.fiap.PetPass.utils.SlackUtils;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @Autowired
    private SlackUtils utils;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getAll() {
        List<ClienteDTO> clientes = service.findAll();

        if (clientes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(clientes);
    }

    @GetMapping("{id}")
    public ResponseEntity<ClienteDTO> getById(@PathVariable Long id) {
        ClienteDTO cliente = service.findById(id);

        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/documento")
    public ResponseEntity<ClienteDTO> getByDocumento(@RequestParam Integer documento) {
        ClienteDTO cliente = service.findByDocumento(documento);

        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(cliente);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> create(@RequestBody ClienteDTO clienteDTO) throws IOException {
        ClienteDTO cliente = service.create(clienteDTO);

        utils.sendMessage("petpass"
                         ,"Client [" + clienteDTO.getId() + "] " + clienteDTO.getNome()
                         + " created successfully at " + LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @PutMapping
    public ClienteDTO update(@RequestBody ClienteDTO clienteDTO) {
        return service.update(clienteDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws IOException {
        ClienteDTO clienteDTO = service.findById(id);

        if (clienteDTO == null) {
            return ResponseEntity.notFound().build();
        }

        service.delete(clienteDTO);

        utils.sendMessage("petpass"
                         ,"Client [" + clienteDTO.getId() + "] " + clienteDTO.getNome()
                         + " deleted successfully at " + LocalDateTime.now());

        return ResponseEntity.ok(id);
    }

    @PostMapping("/cobranca/{id}")
    public ResponseEntity<?> geraCobranca(@PathVariable Long id) throws IOException {
        ClienteDTO clienteDTO = service.findById(id);

        if (clienteDTO == null) {
            return ResponseEntity.notFound().build();
        }

        service.geraCobranca(clienteDTO);

        utils.sendMessage("petpass"
                         ,"Billing was created successfully for Client [" + clienteDTO.getId() + "] "
                         + clienteDTO.getNome()
                         + " at " + LocalDateTime.now());

        return ResponseEntity.ok(id);
    }
}
