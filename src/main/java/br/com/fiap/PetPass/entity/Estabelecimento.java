package br.com.fiap.PetPass.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import br.com.fiap.PetPass.enums.PlanoEnum;

@Entity
@Table(name = "TB_ESTABELECIMENTO")
@EntityListeners(AuditingEntityListener.class)
public class Estabelecimento {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column
	private String nome;
	
	@Column
	private Long documento;
	
	@Column
	private double latitude;
	
	@Column
	private double longitude;
	
	@Column
	private PlanoEnum plano;

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
