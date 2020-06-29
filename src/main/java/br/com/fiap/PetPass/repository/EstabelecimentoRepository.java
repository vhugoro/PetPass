package br.com.fiap.PetPass.repository;

import br.com.fiap.PetPass.entity.Estabelecimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long> {

    Estabelecimento findByDocumento(Long documento);

    Estabelecimento findByNome(String nome);

}
