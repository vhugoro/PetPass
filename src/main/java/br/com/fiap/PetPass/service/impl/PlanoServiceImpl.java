package br.com.fiap.PetPass.service.impl;

import br.com.fiap.PetPass.converter.PlanoConverter;
import br.com.fiap.PetPass.dto.PlanoDTO;
import br.com.fiap.PetPass.entity.Plano;
import br.com.fiap.PetPass.repository.PlanoRepository;
import br.com.fiap.PetPass.service.PlanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanoServiceImpl implements PlanoService {

    @Autowired
    private PlanoRepository repository;

    @Autowired
    private PlanoConverter converter;

    @Override
    public PlanoDTO findByNome(String nome) {
        return this.converter.toDTO(repository.findByNome(nome));
    }

    @Override
    public List<PlanoDTO> findAll() {
        return this.converter.toListDTO(repository.findAll());
    }

    @Override
    public PlanoDTO findById(Long id) {
        return converter.toDTO(repository.findById(id).orElse(null));
    }

    @Override
    public PlanoDTO create(PlanoDTO planoDTO) {
        Plano plano = this.repository.save(converter.toEntity(planoDTO));
        return this.converter.toDTO(plano);
    }

    @Override
    public PlanoDTO update(PlanoDTO planoDTO) {
        Plano plano = this.repository.save(this.converter.toEntity(planoDTO));
        return this.converter.toDTO(plano);
    }

    @Override
    public void delete(PlanoDTO planoDTO) {
        repository.delete(converter.toEntity(planoDTO));
    }
}