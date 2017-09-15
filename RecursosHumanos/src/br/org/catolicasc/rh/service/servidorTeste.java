package br.org.catolicasc.rh.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.ws.Endpoint;

import br.org.catolicasc.rh.dao.CandidatoDAO;
import br.org.catolicasc.rh.dao.QualificacaoDAO;
import br.org.catolicasc.rh.model.Candidato;
import br.org.catolicasc.rh.model.Cursos;
import br.org.catolicasc.rh.model.Empregado;
import br.org.catolicasc.rh.model.Emprego;
import br.org.catolicasc.rh.model.Qualificacoes;
import br.org.catolicasc.rh.model.TipoCurso;

@WebService
public class servidorTeste {

	public static void main(String[] args) {

		System.out.println("\ncreateTest...");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("WebApplication2");

		Cursos cs = new Cursos();
		cs.setCargaHoraria("9 HRS");
		cs.setCidadeDoCurso("Jaraguá do sul");
		cs.setCurso(TipoCurso.TECNICO);
		cs.setInstituicao("Senai");
		cs.setNome("Desenho Mecânico");
		cs.setSimNao(true);

		Emprego em = new Emprego();
		em.setAtividadesDesempenhadas("Auxiliar de Produção");
		em.setCidade("Deus Me Livre");
		em.setDataDemissao(new java.sql.Date(2006, 06, 06));
		em.setDataEmissao(new java.sql.Date(2000, 07, 20));
		em.setEmpresa("Coba");

		Qualificacoes q = new Qualificacoes();

		q.setCursos(new ArrayList<Cursos>());
		q.getCursos().add(cs);

		q.setEmpregos(new ArrayList<Emprego>());
		q.getEmpregos().add(em);

		CandidatoDAO dao = new CandidatoDAO(factory);
		Candidato o = new Candidato();

		o.setNome("Jao");
		o.setEscolaridade("Tecnico");
		o.setSalarioPretendido(1200.00);
		o.setStatus(Empregado.NAO);
		o.setQualificacoes(new ArrayList<Qualificacoes>());
		o.getQualificacoes().add(q);
		o.setIdade(25);
		dao.create(o);

		System.out.println(em.getDataEmissao());
		Endpoint.publish("http://localhost:8080/candidatos", new servidorTeste());
		System.out.println("Servico inicializado!");

	}

	// @WebResult(name = "candidato")
	// public void listandoCandidato(List<Candidato> c){
	// EntityManagerFactory factory =
	// Persistence.createEntityManagerFactory("WebApplication2");
	// CandidatoDAO dao = new CandidatoDAO(factory);
	//
	// for (Candidato c1 : c) {
	// c1.getId();
	// c1.getNome();
	// }
	// dao.findCandidatoEntities();
	// }

	@WebResult(name = "candidato")
	public List<Candidato> listarCandidatos(String teste) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("WebApplication2");
		CandidatoDAO dao = new CandidatoDAO(factory);
		return dao.findCandidatoEntities();
	}

	

	@WebResult(name = "candidato")
	public List buscarCandidatoPorId(List<Candidato> c) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("WebApplication2");
		CandidatoDAO dao = new CandidatoDAO(factory);
		List<Candidato> lst = dao.findCandidatoEntities();
	

		return lst ;
	}

}
