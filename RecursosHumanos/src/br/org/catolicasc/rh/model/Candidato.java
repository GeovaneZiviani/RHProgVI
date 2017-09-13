
package br.org.catolicasc.rh.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@Entity
@Table(name = "Candidato")
@XmlAccessorType(XmlAccessType.FIELD)
public class Candidato implements Serializable {

    private static final long serialVersionUID = 1L;
   

    @XmlElementWrapper(name = "empregos")
    @XmlElement(name = "emprego")
    @XmlJavaTypeAdapter(value = AdaptadorEmprego.class)
    @OneToMany(cascade = CascadeType.ALL)
    private List<Emprego> empregos;

    @XmlElementWrapper(name = "cursos")
    @XmlElement(name = "curso")

    @OneToMany(cascade = CascadeType.ALL)
    private List<Cursos> cursos;
    private String nome;
    private int idade;
    private double salarioPretendido;
    private String escolaridade;

    private Empregado status;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Candidato() {

    }

    public Candidato(Long id, List<Emprego> empregos, List<Cursos> cursos, String nome, int idade, double salarioPretendido, String Escolaridade, Empregado status) {
        super();
        this.id = id;
        this.empregos = empregos;
        this.cursos = cursos;
        this.nome = nome;
        this.idade = idade;
        this.salarioPretendido = salarioPretendido;
        this.escolaridade = Escolaridade;
        this.status = status;
    }

    public Candidato(Long id, List<Emprego> empregos, String nome, int idade, double salarioPretendido, String Escolaridade, Empregado status) {
        this.id = id;
        this.empregos = empregos;
        this.nome = nome;
        this.idade = idade;
        this.salarioPretendido = salarioPretendido;
        this.escolaridade = Escolaridade;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.empregos);
        hash = 37 * hash + Objects.hashCode(this.cursos);
        hash = 37 * hash + Objects.hashCode(this.nome);
        hash = 37 * hash + this.idade;
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.salarioPretendido) ^ (Double.doubleToLongBits(this.salarioPretendido) >>> 32));
        hash = 37 * hash + Objects.hashCode(this.escolaridade);
        hash = 37 * hash + Objects.hashCode(this.status);
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
        final Candidato other = (Candidato) obj;
        if (this.idade != other.idade) {
            return false;
        }
        if (Double.doubleToLongBits(this.salarioPretendido) != Double.doubleToLongBits(other.salarioPretendido)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.escolaridade, other.escolaridade)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.empregos, other.empregos)) {
            return false;
        }
        if (!Objects.equals(this.cursos, other.cursos)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        return true;
    }

}

