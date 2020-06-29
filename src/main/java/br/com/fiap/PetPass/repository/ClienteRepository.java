package br.com.fiap.PetPass.repository;

import br.com.fiap.PetPass.entity.Cliente;
import br.com.fiap.PetPass.enums.PlanoEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByDocumento(Integer documento);

    Cliente findByNome(String Nome);

    List<Cliente> findAllByPlano(PlanoEnum plano);
}
