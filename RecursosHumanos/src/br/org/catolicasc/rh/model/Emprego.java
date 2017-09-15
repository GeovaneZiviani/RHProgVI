/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.rh.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "Emprego")
@XmlAccessorType(XmlAccessType.FIELD)

public class Emprego implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", precision = 0)
	private Long id;

	private String empresa;
	private String cidade;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dataDemissao;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dataEmissao;
	private String atividadesDesempenhadas;

	@ManyToOne
	private Qualificacoes qualificacoes;

	public Emprego() {

	}

	public Emprego(Long id, String empresa, String cidade, Date dataDemissao, Date dataEmissao,
			String atividadesDesempenhadas, Qualificacoes qualificacoes) {
		super();
		this.id = id;
		this.empresa = empresa;
		this.cidade = cidade;
		this.dataDemissao = dataDemissao;
		this.dataEmissao = dataEmissao;
		this.atividadesDesempenhadas = atividadesDesempenhadas;

		this.qualificacoes = qualificacoes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Date getDataDemissao() {
		return dataDemissao;
	}

	public void setDataDemissao(Date dataDemissao) {
		this.dataDemissao = dataDemissao;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public String getAtividadesDesempenhadas() {
		return atividadesDesempenhadas;
	}

	public void setAtividadesDesempenhadas(String atividadesDesempenhadas) {
		this.atividadesDesempenhadas = atividadesDesempenhadas;
	}

	public Qualificacoes getQualificacoes() {
		return qualificacoes;
	}

	public void setQualificacoes(Qualificacoes qualificacoes) {
		this.qualificacoes = qualificacoes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atividadesDesempenhadas == null) ? 0 : atividadesDesempenhadas.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((dataDemissao == null) ? 0 : dataDemissao.hashCode());
		result = prime * result + ((dataEmissao == null) ? 0 : dataEmissao.hashCode());
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((qualificacoes == null) ? 0 : qualificacoes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emprego other = (Emprego) obj;
		if (atividadesDesempenhadas == null) {
			if (other.atividadesDesempenhadas != null)
				return false;
		} else if (!atividadesDesempenhadas.equals(other.atividadesDesempenhadas))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (dataDemissao == null) {
			if (other.dataDemissao != null)
				return false;
		} else if (!dataDemissao.equals(other.dataDemissao))
			return false;
		if (dataEmissao == null) {
			if (other.dataEmissao != null)
				return false;
		} else if (!dataEmissao.equals(other.dataEmissao))
			return false;
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (qualificacoes == null) {
			if (other.qualificacoes != null)
				return false;
		} else if (!qualificacoes.equals(other.qualificacoes))
			return false;
		return true;
	}

}
