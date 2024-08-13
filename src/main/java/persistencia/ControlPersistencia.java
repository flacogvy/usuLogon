package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.CodTabla;
import logica.Persona;
import logica.Usuario;
import utilesDB.utilFecha.UtlFechas;

public class ControlPersistencia {

  UsuarioJpaController controlUsuario = new UsuarioJpaController();
  PersonaJpaController controlPersona = new PersonaJpaController();
  CodTablaJpaController controlTablas = new CodTablaJpaController();

  public void adiPersona(Persona miPer, String usuCrea) {
    miPer.setPer_fehocrea(UtlFechas.getFeHora());
    miPer.setPer_usucrea(usuCrea);
    miPer.setPer_modcrea("JAVA");
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

  public Usuario creaUsuPer(String tipDoc, String numDoc, String nomUsu, String patUsu,
          String matUsu, String aliUsu, String tipUsu, String estUsu, String pasUsu) {
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
                "", "", "ACT", "", "", "", "", "", "", "");
        adiPersona(perCre, "PRUEBAS");
        // recuperar porque ya deberia existir

        
        perTemp = controlPersona.buscaCod(tipDoc, numDoc);
        if (perTemp != null) {
          
          usuRes = new Usuario(11L, aliUsu, perTemp.getPer_id(), pasUsu, tipUsu, estUsu,
                  "", "", "", "", "", "", "");
          controlUsuario.create(usuRes);
        } else {
          
        }
        //return usuCrea;
      } else {
        //
      }
    } else {
      
      return usuRes;
    }

    return usuRes;
  }

  public Persona buscaCodPer(String tipoDoc, String numDoc) {
    return controlPersona.buscaCod(tipoDoc, numDoc);
  }

}
