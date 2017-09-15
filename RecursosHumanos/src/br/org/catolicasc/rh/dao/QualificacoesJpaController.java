
package br.org.catolicasc.rh.dao;

import br.org.catolicasc.rh.dao.exceptions.NonexistentEntityException;
import br.org.catolicasc.rh.model.Qualificacoes;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Jho_z
 */
public class QualificacoesJpaController implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QualificacoesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Qualificacoes qualificacoes) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(qualificacoes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Qualificacoes qualificacoes) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            qualificacoes = em.merge(qualificacoes);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = qualificacoes.getId();
                if (findQualificacoes(id) == null) {
                    throw new NonexistentEntityException("The qualificacoes with id " + id + " no longer exists.");
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
            Qualificacoes qualificacoes;
            try {
                qualificacoes = em.getReference(Qualificacoes.class, id);
                qualificacoes.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The qualificacoes with id " + id + " no longer exists.", enfe);
            }
            em.remove(qualificacoes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Qualificacoes> findQualificacoesEntities() {
        return findQualificacoesEntities(true, -1, -1);
    }

    public List<Qualificacoes> findQualificacoesEntities(int maxResults, int firstResult) {
        return findQualificacoesEntities(false, maxResults, firstResult);
    }

    private List<Qualificacoes> findQualificacoesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Qualificacoes.class));
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

    public Qualificacoes findQualificacoes(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Qualificacoes.class, id);
        } finally {
            em.close();
        }
    }

    public int getQualificacoesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Qualificacoes> rt = cq.from(Qualificacoes.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
