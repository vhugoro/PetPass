package br.com.fiap.PetPass.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.PetPass.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByDocumento(Integer documento);

    Cliente findByNome(String Nome);


}
