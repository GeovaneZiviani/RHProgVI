
package br.org.catolicasc.rh.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "Candidato")
@XmlAccessorType(XmlAccessType.FIELD)
public class Candidato implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@XmlTransient
	private List<Qualificacoes> qualificacoes;
	private String nome;
	private int idade;
	private double salarioPretendido;
	private String escolaridade;
	
	private Empregado status;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Candidato_id", precision = 0)
	private Long id;

	public Candidato() {

	}

	public Candidato(List<Qualificacoes> qualificacoes, String nome, int idade, double salarioPretendido, String escolaridade,
			Empregado status, List<Cursos> cursos, List<Emprego> empregos, Long id) {
		this();
		this.qualificacoes = qualificacoes;
		this.nome = nome;
		this.idade = idade;
		this.salarioPretendido = salarioPretendido;
		this.escolaridade = escolaridade;
		this.status = status;
		this.id = id;
	}

	public List<Qualificacoes> getQualificacoes() {
		return qualificacoes;
	}

	public void setQualificacoes(List<Qualificacoes> qualificacoes) {
		this.qualificacoes = qualificacoes;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getSalarioPretendido() {
		return salarioPretendido;
	}

	public void setSalarioPretendido(double salarioPretendido) {
		this.salarioPretendido = salarioPretendido;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public Empregado getStatus() {
		return status;
	}

	public void setStatus(Empregado status) {
		this.status = status;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((escolaridade == null) ? 0 : escolaridade.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + idade;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((qualificacoes == null) ? 0 : qualificacoes.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salarioPretendido);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Candidato other = (Candidato) obj;
		if (escolaridade == null) {
			if (other.escolaridade != null)
				return false;
		} else if (!escolaridade.equals(other.escolaridade))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idade != other.idade)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (qualificacoes == null) {
			if (other.qualificacoes != null)
				return false;
		} else if (!qualificacoes.equals(other.qualificacoes))
			return false;
		if (Double.doubleToLongBits(salarioPretendido) != Double.doubleToLongBits(other.salarioPretendido))
			return false;
		if (status != other.status)
			return false;
		return true;
	}


	

}
