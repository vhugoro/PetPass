package br.com.fiap.PetPass.dto;

import br.com.fiap.PetPass.entity.Cliente;
import br.com.fiap.PetPass.enums.PlanoEnum;

import java.io.Serializable;
import java.util.StringJoiner;

public class ClienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private Integer documento;
    private PlanoEnum plano;

    public ClienteDTO() {
    }

    public ClienteDTO(String nome, Integer documento, PlanoEnum plano) {
        this.nome = nome;
        this.documento = documento;
        this.plano = plano;
    }

    public ClienteDTO(Long id, String nome, Integer documento, PlanoEnum plano) {
        this.id = id;
        this.nome = nome;
        this.documento = documento;
        this.plano = plano;
    }

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.documento = cliente.getDocumento();
        this.plano = cliente.getPlano();
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

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public PlanoEnum getPlano() {
        return plano;
    }

    public void setPlano(PlanoEnum plano) {
        this.plano = plano;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ClienteDTO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("nome='" + nome + "'")
                .add("documento=" + documento)
                .add("plano='" + plano + "'")
                .toString();
    }

}
