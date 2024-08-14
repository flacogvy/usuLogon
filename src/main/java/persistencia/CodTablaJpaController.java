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
import logica.CodTabla;
import persistencia.exceptions.NonexistentEntityException;

public class CodTablaJpaController implements Serializable {

  public CodTablaJpaController(EntityManagerFactory emf) {
    this.emf = emf;
  }
  
  public CodTablaJpaController() {
    this.emf = Persistence.createEntityManagerFactory("PU_CobJud");
  }
  
  
  private EntityManagerFactory emf = null;

  public EntityManager getEntityManager() {
    return emf.createEntityManager();
  }

  public void create(CodTabla codTabla) {
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      em.persist(codTabla);
      em.getTransaction().commit();
    } finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public void edit(CodTabla codTabla) throws NonexistentEntityException, Exception {
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      codTabla = em.merge(codTabla);
      em.getTransaction().commit();
    } catch (Exception ex) {
      String msg = ex.getLocalizedMessage();
      if (msg == null || msg.length() == 0) {
        Long id = codTabla.getCtaId();
        if (findCodTabla(id) == null) {
          throw new NonexistentEntityException("The codTabla with id " + id + " no longer exists.");
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
      CodTabla codTabla;
      try {
        codTabla = em.getReference(CodTabla.class, id);
        codTabla.getCtaId();
      } catch (EntityNotFoundException enfe) {
        throw new NonexistentEntityException("The codTabla with id " + id + " no longer exists.", enfe);
      }
      em.remove(codTabla);
      em.getTransaction().commit();
    } finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public List<CodTabla> findCodTablaEntities() {
    return findCodTablaEntities(true, -1, -1);
  }

  public List<CodTabla> findCodTablaEntities(int maxResults, int firstResult) {
    return findCodTablaEntities(false, maxResults, firstResult);
  }

  private List<CodTabla> findCodTablaEntities(boolean all, int maxResults, int firstResult) {
    EntityManager em = getEntityManager();
    try {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      cq.select(cq.from(CodTabla.class));
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

  public CodTabla findCodTabla(Long id) {
    EntityManager em = getEntityManager();
    try {
      return em.find(CodTabla.class, id);
    } finally {
      em.close();
    }
  }

  public int getCodTablaCount() {
    EntityManager em = getEntityManager();
    try {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      Root<CodTabla> rt = cq.from(CodTabla.class);
      cq.select(em.getCriteriaBuilder().count(rt));
      Query q = em.createQuery(cq);
      return ((Long) q.getSingleResult()).intValue();
    } finally {
      em.close();
    }
  }
  
  /***********************************/
  /******** adicionado por Yma ******/
  /**
   * @param codTabla
   * @return *********************************/
  
  public List<CodTabla> getCodTablas (String codTabla) {
    EntityManager em1 = getEntityManager();
    List<CodTabla> lisResul;
    try {
      CriteriaBuilder cb = em1.getCriteriaBuilder(); //Paso 1
      CriteriaQuery cqry = em1.getCriteriaBuilder().createQuery(); //Paso 1
      Root<CodTabla> root = cqry.from(CodTabla.class);
      cqry.select(root);  //paso 3
      Predicate pGtCod = cb.equal(root.get("ctaCodigo"), codTabla);
      //cqry.where(pGtCod);
      
      //Predicate pGtAdicional= cb.notLike(exprsn, exprsn1);
      Predicate pGtItm= cb.notEqual(root.get("ctaOpcion"), "___");
      
      Predicate pAnd = cb.and(pGtCod, pGtItm);
      cqry.where(pAnd);
      
      Query qry = em1.createQuery(cqry); //Paso 6
      lisResul = qry.getResultList(); //Paso 6
      
    } finally {
      em1.close();
    }
    return lisResul;
  }

  public String getDescTabla(String cdTablax, String codItemx) {
    EntityManager manager = getEntityManager();
    List<CodTabla> lisResul;
    String descripcion = "";
    try{
      CriteriaBuilder cb = manager.getCriteriaBuilder(); //Paso 1
      CriteriaQuery cqry = manager.getCriteriaBuilder().createQuery(); //Paso 1
      Root<CodTabla> root = cqry.from(CodTabla.class);
      cqry.select(root);  //paso 3
      
      Predicate pGtCod = cb.equal(root.get("ctaCodigo"), cdTablax);
      Predicate pGtItm= cb.equal(root.get("ctaOpcion"), codItemx);
      
      Predicate pAnd = cb.and(pGtCod, pGtItm);
      cqry.where(pAnd);
      
      Query qry = manager.createQuery(cqry); //Paso 6
      lisResul = qry.getResultList(); //Paso 6
      
      switch (lisResul.size()) {
        case 0 : 
          //
          break;
        case 1:
          descripcion = lisResul.get(0).getCtaDescripcion();
          break;
        default:
          //    
      }
        
    } finally {
      manager.close();
    }
    return descripcion;
  }
  
}
