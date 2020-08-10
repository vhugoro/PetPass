package br.com.fiap.PetPass.dto;

import java.io.Serializable;
import java.util.StringJoiner;

import br.com.fiap.PetPass.entity.Plano;

public class PlanoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;

    public PlanoDTO() {
    }

    public PlanoDTO(String nome) {
        this.nome = nome;
    }

    public PlanoDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public PlanoDTO(Plano plano) {
        this.id = plano.getId();
        this.nome = plano.getNome();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PlanoDTO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("nome='" + nome + "'")
                .toString();
    }
}