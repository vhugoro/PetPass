package br.com.fiap.PetPass.repository;

import br.com.fiap.PetPass.entity.Plano;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanoRepository extends JpaRepository<Plano, Long> {
    Plano findByNome(String Nome);
}