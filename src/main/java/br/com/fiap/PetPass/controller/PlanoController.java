package br.com.fiap.PetPass.controller;

import br.com.fiap.PetPass.dto.PlanoDTO;
import br.com.fiap.PetPass.service.PlanoService;
import br.com.fiap.PetPass.utils.SlackUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("planos")
public class PlanoController {
    @Autowired
    private PlanoService service;

    @Autowired
    private SlackUtils utils;

    @GetMapping
    public ResponseEntity<List<PlanoDTO>> getAll() {
        List<PlanoDTO> planos = service.findAll();

        if (planos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(planos);
    }

    @GetMapping("{id}")
    public ResponseEntity<PlanoDTO> getById(@PathVariable Long id) {
        PlanoDTO plano = service.findById(id);

        if (plano == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(plano);
    }

    @PostMapping
    public ResponseEntity<PlanoDTO> create(@RequestBody PlanoDTO planoDTO) throws IOException {
        PlanoDTO plano = service.create(planoDTO);

        utils.sendMessage("petpass", "Plan [" + planoDTO.getId() + "] " + planoDTO.getNome() + " created successfully at " + LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.CREATED).body(plano);
    }

    @PutMapping
    public PlanoDTO update(@RequestBody PlanoDTO planoDTO) {
        return service.update(planoDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws IOException {
        PlanoDTO planoDTO = service.findById(id);

        if (planoDTO == null) {
            return ResponseEntity.notFound().build();
        }

        utils.sendMessage("petpass", "Plan [" + planoDTO.getId() + "] " + planoDTO.getNome() + " deleted successfully at " + LocalDateTime.now());

        service.delete(planoDTO);
        return ResponseEntity.ok(id);

    }
}