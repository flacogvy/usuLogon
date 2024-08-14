package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import logica.Persona;
import persistencia.exceptions.NonexistentEntityException;

public class PersonaJpaController implements Serializable {

  public PersonaJpaController(EntityManagerFactory emf) {
    this.emf = emf;
  }
  
  public PersonaJpaController() {
    this.emf = Persistence.createEntityManagerFactory("PU_CobJud");
  }
  
  private EntityManagerFactory emf = null;

  public EntityManager getEntityManager() {
    return emf.createEntityManager();
  }

  public void create(Persona persona) {
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      em.persist(persona);
      em.getTransaction().commit();
    } finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public void edit(Persona persona) throws NonexistentEntityException, Exception {
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      persona = em.merge(persona);
      em.getTransaction().commit();
    } catch (Exception ex) {
      String msg = ex.getLocalizedMessage();
      if (msg == null || msg.length() == 0) {
        Long id = persona.getPer_id();
        if (findPersona(id) == null) {
          throw new NonexistentEntityException("The persona with id " + id + " no longer exists.");
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
      Persona persona;
      try {
        persona = em.getReference(Persona.class, id);
        persona.getPer_id();
      } catch (EntityNotFoundException enfe) {
        throw new NonexistentEntityException("The persona with id " + id + " no longer exists.", enfe);
      }
      em.remove(persona);
      em.getTransaction().commit();
    } finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public List<Persona> findPersonaEntities() {
    return findPersonaEntities(true, -1, -1);
  }

  public List<Persona> findPersonaEntities(int maxResults, int firstResult) {
    return findPersonaEntities(false, maxResults, firstResult);
  }

  private List<Persona> findPersonaEntities(boolean all, int maxResults, int firstResult) {
    EntityManager em = getEntityManager();
    try {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      cq.select(cq.from(Persona.class));
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

  public Persona findPersona(Long id) {
    EntityManager em = getEntityManager();
    try {
      return em.find(Persona.class, id);
    } finally {
      em.close();
    }
  }

  public int getPersonaCount() {
    EntityManager em = getEntityManager();
    try {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      Root<Persona> rt = cq.from(Persona.class);
      cq.select(em.getCriteriaBuilder().count(rt));
      Query q = em.createQuery(cq);
      return ((Long) q.getSingleResult()).intValue();
    } finally {
      em.close();
    }
  }

  Persona buscaCod(String tipDoc, String numDoc) {
    EntityManager manager = getEntityManager();
    List<Persona> lisResul;
    Persona miPer = null;
    
    try {
      CriteriaBuilder cb = manager.getCriteriaBuilder(); //Paso 1
      CriteriaQuery cqry = manager.getCriteriaBuilder().createQuery(); //Paso 1
      Root<Persona> root = cqry.from(Persona.class);
      cqry.select(root);  //paso 3
      Predicate pGtTipo = cb.equal(root.get("per_tipdoc"), tipDoc);
      Predicate pGtCode= cb.equal(root.get("per_numcod"), numDoc);
      
      Predicate pTodo = cb.and(pGtTipo, pGtCode);
      cqry.where(pTodo);
      
      Query qry = manager.createQuery(cqry); //Paso 6
      lisResul = qry.getResultList();
      if (lisResul.size() == 1) {
        
        miPer = lisResul.get(0);
      }  else  {
        
        return miPer;
      }
      
    } finally {
      manager.close();
    }
    return miPer;
  }
  
}
