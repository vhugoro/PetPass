package br.com.fiap.PetPass.service;

import br.com.fiap.PetPass.dto.EstabelecimentoDTO;

import java.util.List;

public interface EstabelecimentoService {

    EstabelecimentoDTO find(EstabelecimentoDTO estabelecimento);

    EstabelecimentoDTO findByDocumento(Long documento);

    EstabelecimentoDTO findByNome(String nomeEstabelecimento);

    List<EstabelecimentoDTO> findAll();

    EstabelecimentoDTO create(EstabelecimentoDTO estabelecimento);

    EstabelecimentoDTO update(EstabelecimentoDTO estabelecimento);

    void delete(Long id);

    EstabelecimentoDTO findById(Long id);

}
