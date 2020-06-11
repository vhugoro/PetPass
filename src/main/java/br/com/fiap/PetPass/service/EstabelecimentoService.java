package br.com.fiap.PetPass.service;

import java.util.List;

import br.com.fiap.PetPass.dto.EstabelecimentoDTO;

public interface EstabelecimentoService {
	
	EstabelecimentoDTO find(EstabelecimentoDTO estabelecimento);

	EstabelecimentoDTO findByDocumento(Integer documento);

	EstabelecimentoDTO findByNome(String nomeEstabelecimento);

    List<EstabelecimentoDTO> findAll();

    EstabelecimentoDTO create(EstabelecimentoDTO estabelecimento);

    EstabelecimentoDTO update(EstabelecimentoDTO estabelecimento);

    void delete(Long id);

	EstabelecimentoDTO findById(Long id);

}
