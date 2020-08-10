package br.com.fiap.PetPass.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.PetPass.entity.Plano;

public interface PlanoRepository extends JpaRepository<Plano, Long> {
    Plano findByNome(String Nome);
}