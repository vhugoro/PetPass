package br.com.fiap.PetPass.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.fiap.PetPass.dto.EstabelecimentoDTO;
import br.com.fiap.PetPass.entity.Estabelecimento;

@Service
public class EstabelecimentoConverter {

	public EstabelecimentoDTO toDTO(Estabelecimento estabelecimento) {
		return new EstabelecimentoDTO(estabelecimento);
	}
	
	public List<EstabelecimentoDTO> toListDTO(List<Estabelecimento> estabelecimentos) {
		return estabelecimentos.stream()
				.map(this::toDTO)
				.collect(Collectors.toList());
	}
	
	public Estabelecimento toEntity(EstabelecimentoDTO estabelecimentoDTO) {
		Estabelecimento estabelecimento = new Estabelecimento();
		
		estabelecimento.setDocumento(estabelecimentoDTO.getDocumento());
		estabelecimento.setId(estabelecimentoDTO.getId());
		estabelecimento.setLatitude(estabelecimentoDTO.getLatitude());
		estabelecimento.setLongitude(estabelecimentoDTO.getLongitude());
		estabelecimento.setNome(estabelecimentoDTO.getNome());
		estabelecimento.setPlano(estabelecimentoDTO.getPlano());
		
		return estabelecimento;
	}
	
	public List<Estabelecimento> toListEntity(List<EstabelecimentoDTO> estabelecimentosDTO) {
		return estabelecimentosDTO.stream()
				.map(this::toEntity)
				.collect(Collectors.toList());
	}
	
}
