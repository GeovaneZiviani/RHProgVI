package br.org.catolicasc.rh.dao;

import br.org.catolicasc.rh.model.Candidato;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Jho_z
 */
public class CandidatoDAO extends CandidatoJpaController implements ICandidatoDAO {

	public CandidatoDAO(EntityManagerFactory emf) {
		super(emf);
	}

	public Candidato ObterIdCadidato(Long id) {
		EntityManagerFactory emf = null;
		Candidato result = null;
		for (Candidato candidato : new CandidatoDAO(emf).findCandidatoEntities()) {
			if (candidato.getId() == id) {
				result = candidato;
			}
		}
		return result;
	}
}
