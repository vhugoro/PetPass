package br.com.fiap.PetPass.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.PetPass.entity.Cliente;
import br.com.fiap.PetPass.enums.PlanoEnum;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByDocumento(Integer documento);

    Cliente findByNome(String Nome);

    List<Cliente> findAllByPlano(PlanoEnum plano);

}
