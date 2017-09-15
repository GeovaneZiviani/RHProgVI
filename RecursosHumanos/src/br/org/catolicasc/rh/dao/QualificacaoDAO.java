package br.org.catolicasc.rh.dao;

import javax.persistence.EntityManagerFactory;

public class QualificacaoDAO extends QualificacoesJpaController  {

	private static final long serialVersionUID = 1L;

	public QualificacaoDAO(EntityManagerFactory emf) {
		super(emf);
		
	}

}
