package br.org.catolicasc.rh.dao;

import br.org.catolicasc.rh.dao.exceptions.NonexistentEntityException;
import br.org.catolicasc.rh.model.Emprego;
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
public class EmpregoJpaController implements Serializable {

    public EmpregoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Emprego emprego) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(emprego);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Emprego emprego) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            emprego = em.merge(emprego);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = emprego.getId();
                if (findEmprego(id) == null) {
                    throw new NonexistentEntityException("The emprego with id " + id + " no longer exists.");
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
            Emprego emprego;
            try {
                emprego = em.getReference(Emprego.class, id);
                emprego.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The emprego with id " + id + " no longer exists.", enfe);
            }
            em.remove(emprego);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Emprego> findEmpregoEntities() {
        return findEmpregoEntities(true, -1, -1);
    }

    public List<Emprego> findEmpregoEntities(int maxResults, int firstResult) {
        return findEmpregoEntities(false, maxResults, firstResult);
    }

    private List<Emprego> findEmpregoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Emprego.class));
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

    public Emprego findEmprego(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Emprego.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmpregoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Emprego> rt = cq.from(Emprego.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}