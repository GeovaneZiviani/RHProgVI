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
import br.org.catolicasc.rh.model.Candidato;
import br.org.catolicasc.rh.model.Cursos;
import br.org.catolicasc.rh.model.Empregado;
import br.org.catolicasc.rh.model.Emprego;
import br.org.catolicasc.rh.model.TipoCurso;

@WebService
public class servidorTeste {

	public static void main(String[] args) {

		System.out.println("\ncreateTest...");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("WebApplication2");
		CandidatoDAO dao = new CandidatoDAO(factory);
		
		
		Candidato o = new Candidato();
		Cursos cs = new Cursos();
		cs.setCargaHoraria("1500 HRS");
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
		em.setEmpresa("Cuba");
		o.setNome("Jao");
		o.setCursos(new ArrayList<Cursos>());
		o.getCursos().add(cs);
		o.setEscolaridade("Tecnico");
		o.setSalarioPretendido(1200.00);
		o.setStatus(Empregado.NAO);
		o.setEmpregos(new ArrayList<Emprego>());
		o.getEmpregos().add(em);
		o.setIdade(25);
		dao.create(o);
		
		
	     System.out.println(o.getId());
			
		
		

		Endpoint.publish("http://localhost:8080/candidatos", new servidorTeste());
		System.out.println("Servico inicializado!");

	}

	

	@WebResult(name = "candidato")
	public Candidato buscarCandidatoPorId(@WebParam(name = "id") Long id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("WebApplication2");
		CandidatoDAO candidatoDAO = new CandidatoDAO(factory);
		return candidatoDAO.ObterIdCadidato(id);
	}

	@WebResult(name = "candidato")
	public List<Candidato> listarCandidatos(String teste) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("WebApplication2");
		CandidatoDAO dao = new CandidatoDAO(factory);
		return dao.findCandidatoEntities();
	}

}
