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
    @XmlTransient
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDemissao;
    @XmlTransient
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataEmissao;
    private String atividadesDesempenhadas;

    @ManyToOne
    private Candidato candidato;

    public Emprego() {

    }

    public Emprego(Long id, String empresa, String cidade, Date dataDemissao, Date dataEmissao, String atividadesDesempenhadas, Candidato candidato) {
        super();
        this.id = id;
        this.empresa = empresa;
        this.cidade = cidade;
        this.dataDemissao = dataDemissao;
        this.dataEmissao = dataEmissao;
        this.atividadesDesempenhadas = atividadesDesempenhadas;
        this.candidato = candidato;
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

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.empresa);
        hash = 71 * hash + Objects.hashCode(this.cidade);
        hash = 71 * hash + Objects.hashCode(this.dataDemissao);
        hash = 71 * hash + Objects.hashCode(this.dataEmissao);
        hash = 71 * hash + Objects.hashCode(this.atividadesDesempenhadas);
        hash = 71 * hash + Objects.hashCode(this.candidato);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Emprego other = (Emprego) obj;
        if (!Objects.equals(this.empresa, other.empresa)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (!Objects.equals(this.atividadesDesempenhadas, other.atividadesDesempenhadas)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dataDemissao, other.dataDemissao)) {
            return false;
        }
        if (!Objects.equals(this.dataEmissao, other.dataEmissao)) {
            return false;
        }
        if (!Objects.equals(this.candidato, other.candidato)) {
            return false;
        }
        return true;
    }

}
