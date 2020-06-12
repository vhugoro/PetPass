package br.com.fiap.PetPass.dto;

import java.io.Serializable;

import br.com.fiap.PetPass.entity.Estabelecimento;
import br.com.fiap.PetPass.enums.PlanoEnum;

public class EstabelecimentoDTO implements Serializable {

	private static final long serialVersionUID = 8749950324503171310L;
	
	private Long id;
	private String nome;
	private Long documento;
	private double latitude;
	private double longitude;
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

	public Long getDocumento() {
		return documento;
	}

	public void setDocumento(Long documento) {
		this.documento = documento;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public PlanoEnum getPlano() {
		return plano;
	}

	public void setPlano(PlanoEnum plano) {
		this.plano = plano;
	}
	
}
