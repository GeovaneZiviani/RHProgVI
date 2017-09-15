
package br.org.catolicasc.rh.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Cursos")
public class Cursos implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Qualificacoes qualificacoes;

	@ManyToOne
	private Candidato candidato;
	private String nome;
	private String cargaHoraria;
	private TipoCurso curso;
	private boolean simNao;
	private String instituicao;
	private String cidadeDoCurso;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", precision = 0)
	private Long id;

	public Cursos() {

	}

	public Cursos(Qualificacoes qualificacoes, Candidato candidato, String nome, String cargaHoraria, TipoCurso curso,
			boolean simNao, String instituicao, String cidadeDoCurso, Long id) {
		super();
		this.qualificacoes = qualificacoes;
		this.candidato = candidato;
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
		this.curso = curso;
		this.simNao = simNao;
		this.instituicao = instituicao;
		this.cidadeDoCurso = cidadeDoCurso;
		this.id = id;
	}

	public Qualificacoes getQualificacoes() {
		return qualificacoes;
	}

	public void setQualificacoes(Qualificacoes qualificacoes) {
		this.qualificacoes = qualificacoes;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(String cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public TipoCurso getCurso() {
		return curso;
	}

	public void setCurso(TipoCurso curso) {
		this.curso = curso;
	}

	public boolean isSimNao() {
		return simNao;
	}

	public void setSimNao(boolean simNao) {
		this.simNao = simNao;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public String getCidadeDoCurso() {
		return cidadeDoCurso;
	}

	public void setCidadeDoCurso(String cidadeDoCurso) {
		this.cidadeDoCurso = cidadeDoCurso;
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
		result = prime * result + ((candidato == null) ? 0 : candidato.hashCode());
		result = prime * result + ((cargaHoraria == null) ? 0 : cargaHoraria.hashCode());
		result = prime * result + ((cidadeDoCurso == null) ? 0 : cidadeDoCurso.hashCode());
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((instituicao == null) ? 0 : instituicao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((qualificacoes == null) ? 0 : qualificacoes.hashCode());
		result = prime * result + (simNao ? 1231 : 1237);
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
		Cursos other = (Cursos) obj;
		if (candidato == null) {
			if (other.candidato != null)
				return false;
		} else if (!candidato.equals(other.candidato))
			return false;
		if (cargaHoraria == null) {
			if (other.cargaHoraria != null)
				return false;
		} else if (!cargaHoraria.equals(other.cargaHoraria))
			return false;
		if (cidadeDoCurso == null) {
			if (other.cidadeDoCurso != null)
				return false;
		} else if (!cidadeDoCurso.equals(other.cidadeDoCurso))
			return false;
		if (curso != other.curso)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (instituicao == null) {
			if (other.instituicao != null)
				return false;
		} else if (!instituicao.equals(other.instituicao))
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
		if (simNao != other.simNao)
			return false;
		return true;
	}

}
