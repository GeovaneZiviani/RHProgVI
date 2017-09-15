package br.org.catolicasc.rh.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "qualificacao")
@XmlAccessorType(XmlAccessType.FIELD)
public class Qualificacoes extends Candidato implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElementWrapper(name = "empregos")
	@XmlElement(name = "emprego")
	@OneToMany(cascade = CascadeType.ALL)
	private List<Emprego> empregos;

	@XmlElementWrapper(name = "cursos")
	@XmlElement(name = "curso")
	@OneToMany(cascade = CascadeType.ALL)
	private List<Cursos> cursos;

	
	@ManyToOne
	private Candidato candidato;

	public Qualificacoes() {
		super();

	}

	public Qualificacoes(Long id, List<Emprego> empregos, List<Cursos> cursos, Candidato candidato) {
		this();
		this.empregos = empregos;
		this.cursos = cursos;
		this.candidato = candidato;
	}

	public List<Emprego> getEmpregos() {
		return empregos;
	}

	public void setEmpregos(List<Emprego> empregos) {
		this.empregos = empregos;
	}

	public List<Cursos> getCursos() {
		return cursos;
	}

	public void setCursos(List<Cursos> cursos) {
		this.cursos = cursos;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((candidato == null) ? 0 : candidato.hashCode());
		result = prime * result + ((cursos == null) ? 0 : cursos.hashCode());
		result = prime * result + ((empregos == null) ? 0 : empregos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Qualificacoes other = (Qualificacoes) obj;
		if (candidato == null) {
			if (other.candidato != null)
				return false;
		} else if (!candidato.equals(other.candidato))
			return false;
		if (cursos == null) {
			if (other.cursos != null)
				return false;
		} else if (!cursos.equals(other.cursos))
			return false;
		if (empregos == null) {
			if (other.empregos != null)
				return false;
		} else if (!empregos.equals(other.empregos))
			return false;
		return true;
	}

}
