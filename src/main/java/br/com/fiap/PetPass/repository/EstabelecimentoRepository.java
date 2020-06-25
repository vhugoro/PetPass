package br.com.fiap.PetPass.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.PetPass.entity.Estabelecimento;

public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long> {
	
	Estabelecimento findByDocumento(Long documento);
	
	Estabelecimento findByNome(String nome);

}
