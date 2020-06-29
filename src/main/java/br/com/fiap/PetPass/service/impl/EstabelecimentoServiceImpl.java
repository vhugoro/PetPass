package br.com.fiap.PetPass.service.impl;

import br.com.fiap.PetPass.converter.EstabelecimentoConverter;
import br.com.fiap.PetPass.dto.EstabelecimentoDTO;
import br.com.fiap.PetPass.entity.Estabelecimento;
import br.com.fiap.PetPass.repository.EstabelecimentoRepository;
import br.com.fiap.PetPass.service.EstabelecimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstabelecimentoServiceImpl implements EstabelecimentoService {

    @Autowired
    private EstabelecimentoRepository repository;

    @Autowired
    private EstabelecimentoConverter converter;

    @Override
    public EstabelecimentoDTO find(EstabelecimentoDTO estabelecimentoDTO) {
        Estabelecimento estabelecimento = this.repository.findById(estabelecimentoDTO.getId()).orElse(null);
        return this.converter.toDTO(estabelecimento);

    }

    @Override
    public EstabelecimentoDTO findByDocumento(Long documento) {
        Estabelecimento estabelecimento = this.repository.findByDocumento(documento);
        return this.converter.toDTO(estabelecimento);
    }

    @Override
    public EstabelecimentoDTO findByNome(String nomeEstabelecimento) {
        Estabelecimento estabelecimento = this.repository.findByNome(nomeEstabelecimento);
        return this.converter.toDTO(estabelecimento);
    }

    @Override
    public EstabelecimentoDTO findById(Long id) {
        Estabelecimento estabelecimento = this.repository.findById(id).orElse(null);
        return this.converter.toDTO(estabelecimento);
    }

    @Override
    public List<EstabelecimentoDTO> findAll() {
        List<Estabelecimento> estabelecimentos = this.repository.findAll();
        return this.converter.toListDTO(estabelecimentos);
    }

    @Override
    public EstabelecimentoDTO create(EstabelecimentoDTO estabelecimentoDTO) {
        Estabelecimento estabelecimento = repository.save(this.converter.toEntity(estabelecimentoDTO));
        return this.converter.toDTO(estabelecimento);
    }

    @Override
    public EstabelecimentoDTO update(EstabelecimentoDTO estabelecimentoDTO) {
        Estabelecimento estabelecimento = repository.save(this.converter.toEntity(estabelecimentoDTO));
        return this.converter.toDTO(estabelecimento);
    }

    @Override
    public void delete(Long id) {
        Estabelecimento estabelecimento = this.repository.findById(id).orElse(null);
        if (estabelecimento != null) {
            this.repository.delete(estabelecimento);
        }
    }

}
