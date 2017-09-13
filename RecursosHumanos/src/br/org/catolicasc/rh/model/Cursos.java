
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

    public Cursos(Candidato candidato, String nome, String cargaHoraria, TipoCurso curso, boolean simNao, String instituicao, String cidadeDoCurso, Long id) {
        super();
        this.candidato = candidato;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.curso = curso;
        this.simNao = simNao;
        this.instituicao = instituicao;
        this.cidadeDoCurso = cidadeDoCurso;
        this.id = id;
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
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.candidato);
        hash = 59 * hash + Objects.hashCode(this.nome);
        hash = 59 * hash + Objects.hashCode(this.cargaHoraria);
        hash = 59 * hash + Objects.hashCode(this.curso);
        hash = 59 * hash + (this.simNao ? 1 : 0);
        hash = 59 * hash + Objects.hashCode(this.instituicao);
        hash = 59 * hash + Objects.hashCode(this.cidadeDoCurso);
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Cursos other = (Cursos) obj;
        if (this.simNao != other.simNao) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cargaHoraria, other.cargaHoraria)) {
            return false;
        }
        if (!Objects.equals(this.instituicao, other.instituicao)) {
            return false;
        }
        if (!Objects.equals(this.cidadeDoCurso, other.cidadeDoCurso)) {
            return false;
        }
        if (!Objects.equals(this.candidato, other.candidato)) {
            return false;
        }
        if (this.curso != other.curso) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
   
}
