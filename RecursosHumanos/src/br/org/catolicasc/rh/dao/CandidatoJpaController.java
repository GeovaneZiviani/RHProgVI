package br.org.catolicasc.rh.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.org.catolicasc.rh.dao.exceptions.NonexistentEntityException;
import br.org.catolicasc.rh.model.Candidato;

public class CandidatoJpaController implements Serializable {
	public CandidatoJpaController(EntityManagerFactory emf) {
		this.emf = emf;
	}

	EntityManagerFactory emf = null;

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public void create(Candidato candidato) {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.persist(candidato);
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public void edit(Candidato candidato) throws NonexistentEntityException, Exception {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			candidato = em.merge(candidato);
			em.getTransaction().commit();
		} catch (Exception ex) {
			String msg = ex.getLocalizedMessage();
			if (msg == null || msg.length() == 0) {
				Long id = candidato.getId();
				if (findCandidato(id) == null) {
					throw new NonexistentEntityException("The candidato with id " + id + " no longer exists.");
				}
			}
			throw ex;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public void destroy(Long id) throws NonexistentEntityException {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			Candidato candidato;
			try {
				candidato = em.getReference(Candidato.class, id);
				candidato.getId();
			} catch (EntityNotFoundException enfe) {
				throw new NonexistentEntityException("The candidato with id " + id + " no longer exists.", enfe);
			}
			em.remove(candidato);
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public List<Candidato> findCandidatoEntities() {
		return findCandidatoEntities(true, -1, -1);
	}

	public List<Candidato> findCandidatoEntities(int maxResults, int firstResult) {
		return findCandidatoEntities(false, maxResults, firstResult);
	}

	private List<Candidato> findCandidatoEntities(boolean all, int maxResults, int firstResult) {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			cq.select(cq.from(Candidato.class));
			Query q = em.createQuery(cq);
			if (!all) {
				q.setMaxResults(maxResults);
				q.setFirstResult(firstResult);
			}
			return q.getResultList();
		} finally {
			em.close();
		}
	}

	public Candidato findCandidato(Long id) {
		EntityManager em = getEntityManager();
		try {
			return em.find(Candidato.class, id);
		} finally {
			em.close();
		}
	}

	public int getCandidatoCount() {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			Root<Candidato> rt = cq.from(Candidato.class);
			cq.select(em.getCriteriaBuilder().count(rt));
			Query q = em.createQuery(cq);
			return ((Long) q.getSingleResult()).intValue();
		} finally {
			em.close();
		}
	}
}
