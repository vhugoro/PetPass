package br.com.fiap.PetPass.dto;

import java.io.Serializable;
import java.util.StringJoiner;

import br.com.fiap.PetPass.entity.Cliente;

public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long    id;
    private String  nome;
    private Integer documento;
    private String  planoId;

    public ClienteDTO() { }

    public ClienteDTO(String nome ,Integer documento ,String planoId) {
        this.nome      = nome;
        this.documento = documento;
        this.planoId   = planoId;
    }

    public ClienteDTO(Long id ,String nome ,Integer documento ,String planoId) {
        this.id        = id;
        this.nome      = nome;
        this.documento = documento;
        this.planoId   = planoId;
    }

    public ClienteDTO(Cliente cliente) {
        this.id        = cliente.getId();
        this.nome      = cliente.getNome();
        this.documento = cliente.getDocumento();
        this.planoId   = cliente.getPlanoId();
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

	public String getPlanoId() {
		return planoId;
	}

	public void setPlanoId(String planoId) {
		this.planoId = planoId;
	}

	@Override
    public String toString() {
        return new StringJoiner(", " ,ClienteDTO.class.getSimpleName() + "[" ,"]")
                .add("id=" + id)
                .add("nome='" + nome + "'")
                .add("documento=" + documento)
                .add("planoId='" + planoId + "'")
                .toString();
    }

}
