package br.com.fiap.PetPass.dto;

import java.io.Serializable;

import br.com.fiap.PetPass.entity.Estabelecimento;
import br.com.fiap.PetPass.enuns.PlanoEnum;

public class EstabelecimentoDTO implements Serializable {

	private static final long serialVersionUID = 8749950324503171310L;
	
	private Long id;
	private String nome;
	private int documento;
	private int latitude;
	private int longitude;
	private PlanoEnum plano;
	
	public EstabelecimentoDTO(Estabelecimento estabelecimento) {
		this.nome = estabelecimento.getNome();
		this.documento = estabelecimento.getDocumento();
		this.latitude = estabelecimento.getLatitude();
		this.longitude = estabelecimento.getLongitude();
		this.plano = estabelecimento.getPlano();
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

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public int getLatitude() {
		return latitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public int getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	public PlanoEnum getPlano() {
		return plano;
	}

	public void setPlano(PlanoEnum plano) {
		this.plano = plano;
	}
	
}
