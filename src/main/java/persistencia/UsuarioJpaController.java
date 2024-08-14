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
import logica.Usuario;
import persistencia.exceptions.NonexistentEntityException;

public class UsuarioJpaController implements Serializable {

  public UsuarioJpaController(EntityManagerFactory emf) {
    this.emf = emf;
  }

  public UsuarioJpaController() {
    this.emf = Persistence.createEntityManagerFactory("PU_CobJud");
  }

  private EntityManagerFactory emf = null;

  public EntityManager getEntityManager() {
    return emf.createEntityManager();
  }

  public void create(Usuario usuario) {
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      em.persist(usuario);
      em.getTransaction().commit();
    } finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public void edit(Usuario usuario) throws NonexistentEntityException, Exception {
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      usuario = em.merge(usuario);
      em.getTransaction().commit();
    } catch (Exception ex) {
      String msg = ex.getLocalizedMessage();
      if (msg == null || msg.length() == 0) {
        Long id = usuario.getUsr_id();
        if (findUsuario(id) == null) {
          throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.");
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
      Usuario usuario;
      try {
        usuario = em.getReference(Usuario.class, id);
        usuario.getUsr_id();
      } catch (EntityNotFoundException enfe) {
        throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.", enfe);
      }
      em.remove(usuario);
      em.getTransaction().commit();
    } finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public List<Usuario> findUsuarioEntities() {
    return findUsuarioEntities(true, -1, -1);
  }

  public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
    return findUsuarioEntities(false, maxResults, firstResult);
  }

  private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
    EntityManager em = getEntityManager();
    try {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      cq.select(cq.from(Usuario.class));
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

  public Usuario findUsuario(Long id) {
    EntityManager em = getEntityManager();
    try {
      return em.find(Usuario.class, id);
    } finally {
      em.close();
    }
  }

  public int getUsuarioCount() {
    EntityManager em = getEntityManager();
    try {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      Root<Usuario> rt = cq.from(Usuario.class);
      cq.select(em.getCriteriaBuilder().count(rt));
      Query q = em.createQuery(cq);
      return ((Long) q.getSingleResult()).intValue();
    } finally {
      em.close();
    }
  }

  
  /*creado or Ymanuel */
  public Usuario getUsuXAlias(String alias) {
    EntityManager miManager = getEntityManager();
    Usuario usuRecu = null;
    List<Usuario> lisResul;
    try {
      CriteriaBuilder cb = miManager.getCriteriaBuilder();
      CriteriaQuery cqry = miManager.getCriteriaBuilder().createQuery();
      Root<Usuario> root = cqry.from(Usuario.class);
      cqry.select(root);
      Predicate pGtAlias = cb.equal(root.get("usr_alias"), alias);
      cqry.where(pGtAlias);

      Query qry = miManager.createQuery(cqry);
      lisResul = qry.getResultList();

      if (lisResul.size() == 1) {
        usuRecu = lisResul.get(0);
      } else {
        lisResul = null;
      }
      return usuRecu;

    } finally {
      miManager.close();
    }

  }

  public List<Usuario> getUsuFiltro(String strFiltro) {
    EntityManager manager = getEntityManager();
    List<Usuario> lisResul;
    try {
      CriteriaBuilder cb = manager.getCriteriaBuilder(); //Paso 1
      CriteriaQuery cqry = manager.getCriteriaBuilder().createQuery(); //Paso 1
      Root<Usuario> root = cqry.from(Usuario.class);
      cqry.select(root);  //paso 3
      //Predicate pGtCod = cb.eq (root.get("ctaCodigo"), codTabla);
      Predicate pGtAlias = cb.like (root.<String>get("usr_alias"), '%' + strFiltro + '%');
      cqry.where(pGtAlias);
      
      Query qry = manager.createQuery(cqry); //Paso 6
      lisResul = qry.getResultList(); //Paso 6
      
    } finally {
      manager.close();
    }
      
    return lisResul;
  }

public  String buscaUsuPer(Long per_id, Usuario usuRes) {
    String zMensa = "";
    EntityManager manager = getEntityManager();
    Usuario mioUsuario = null;
    List<Usuario> lisResul;
    try {
      CriteriaBuilder cb = manager.getCriteriaBuilder(); //Paso 1
      CriteriaQuery cqry = manager.getCriteriaBuilder().createQuery(); //Paso 1
      Root<Usuario> root = cqry.from(Usuario.class);
      cqry.select(root);  //paso 3
      Predicate pEquPerId = cb.equal(root.get("per_id"), per_id);
      cqry.where(pEquPerId);
      
      Query qry = manager.createQuery(cqry); //Paso 6
      lisResul = qry.getResultList(); //Paso 6
      if (lisResul.size() == 1)  {
        
        mioUsuario = lisResul.get(0);
        usuRes.copiar(mioUsuario);
        
      } else {
        if (lisResul.size() == 0 ) {
          //
          usuRes = null;
        }  else {
          zMensa = "ERR-Hay mas de 1 usuario con el codigo de Persona";
        }
      }
      
    } finally {
      manager.close();
    }
    
    /*por alguna razon no se puede hacer usuRes = mioUsuario 
      por eso se ha creado el metodo copiar en Usuario   */
    
    
    return zMensa;
  }

  
}
