package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.CodTabla;
import logica.Persona;
import logica.Usuario;
import persistencia.exceptions.NonexistentEntityException;
import utilesDB.utilFecha.UtlFecTime;
import utilesDB.utilFecha.UtlFechas;
import utilesDB.utilGen.EncripCad;

public class ControlPersistencia {

  UsuarioJpaController controlUsuario = new UsuarioJpaController();
  PersonaJpaController controlPersona = new PersonaJpaController();
  CodTablaJpaController controlTablas = new CodTablaJpaController();

  public void adiPersona(Persona miPer) {
    controlPersona.create(miPer);
  }

  public void adiUsuario(Usuario miUsr) {
    controlUsuario.create(miUsr);
  }

  public List<CodTabla> listTabla(String codTabla) {
    return (controlTablas.getCodTablas(codTabla));
  }

  public Usuario getUsuAlias(String elAlias) {
    return controlUsuario.getUsuXAlias(elAlias);
  }

  public List<Usuario> getUsuFiltro(String strFiltro) {
    return controlUsuario.getUsuFiltro(strFiltro);
  }

  public void modiUsu(Usuario valUsu) {
    try {
      controlUsuario.edit(valUsu);
    } catch (Exception ex) {
      Logger.getLogger(ControlPersistencia.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public Persona findPersona(Long per_id) {
    return controlPersona.findPersona(per_id);
  }

  public String creaUsuPer(String tipDoc, String numDoc, String nomUsu, String patUsu,
          String matUsu, String aliUsu, String tipUsu, String estUsu, String pasUsu,
          String modCrea, String usuCrea, Usuario unUsu) {
    String zMensa = "";
    Usuario usuRes = null;

    //Verificar que no exista Alias repetido
    Usuario usuTemp = controlUsuario.getUsuXAlias(aliUsu);

    if (usuTemp == null) {
      //ALias esta libre
      //verificar si persona existe
      Persona perTemp = controlPersona.buscaCod(tipDoc, numDoc);

      if (perTemp == null) {
        
        // crear persona y Usuario
        Persona perCre = new Persona(12L, tipDoc, numDoc, nomUsu, patUsu, matUsu,
                "", "", "ACT", "", UtlFecTime.getFeHora() , usuCrea, modCrea, "", "", "");
        adiPersona(perCre);

        // recuperar porque ya deberia existir
        perTemp = controlPersona.buscaCod(tipDoc, numDoc);
        if (perTemp != null) {

          //Encriptar el password
          String passDis = EncripCad.encrCadII(pasUsu);
          usuRes = new Usuario(11L, aliUsu, perTemp.getPer_id(), passDis, tipUsu, estUsu,
                  "", UtlFecTime.getFeHora() ,usuCrea, modCrea, "", "", "");
          
          controlUsuario.create(usuRes);

          //Usuario de Salida
          unUsu.copiar(usuRes);
          //unUsu = usuRes;
          
          return "EXI-Usuario y Persona Creados con exito";

        } else {
        }
        //return usuCrea;
      } else {
        
        // Persona ya Existe -- Verificar que persona no tenga Usuario
        Usuario newUsuario = new Usuario();

        zMensa = controlUsuario.buscaUsuPer(perTemp.getPer_id(), newUsuario);

        if (newUsuario.getUsr_id() == null) {
          // Crear el Usuario
          newUsuario.setUsr_id(1L);
          newUsuario.setUsr_alias(aliUsu);
          newUsuario.setPer_id(perTemp.getPer_id());
          
          String passDis = EncripCad.encrCadII(pasUsu);
          newUsuario.setUsr_password(passDis);
          newUsuario.setUsr_tipo(tipUsu);
          newUsuario.setUsr_estado(estUsu);
          newUsuario.setUsr_ultlogon("");
          newUsuario.setUsr_fehocrea(UtlFecTime.getFeHora());
          newUsuario.setUsr_usucrea(usuCrea);
          newUsuario.setUsr_modcrea(modCrea);
          newUsuario.setUsr_fehomodi("");
          newUsuario.setUsr_usumodi("");
          newUsuario.setUsr_modmodi("");
          controlUsuario.create(newUsuario);
          
          zMensa = "EXI-Usuario creado con: " + perTemp.getPer_tipdoc() + 
                  " " + perTemp.getPer_numcod();
        } else {
          //
          zMensa = "ERR-Ya existe un Usuario para esa Persona";
        }
      }
    } else {
      zMensa = "ERR-El Alias ya existe";
      return zMensa;
    }

    return zMensa;
  }

  public Persona buscaCodPer(String tipoDoc, String numDoc) {
    return controlPersona.buscaCod(tipoDoc, numDoc);
  }

  public Persona getPersona(Long per_id) {
    return controlPersona.findPersona(per_id);
  }

  public Usuario getUsuario(Long idUsuario) {
    return controlUsuario.findUsuario(idUsuario);
  }

  public void elimUsuario(Long idUsuario) {
    try {
      controlUsuario.destroy(idUsuario);
    } catch (NonexistentEntityException ex) {
      Logger.getLogger(ControlPersistencia.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public void modiPersona(Persona perCambio) {
    try {
      controlPersona.edit(perCambio);
    } catch (Exception ex) {
      Logger.getLogger(ControlPersistencia.class.getName()).log(Level.SEVERE, null, ex);
    }
    
  }

}
