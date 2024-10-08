package logica;

import java.util.List;
import persistencia.ControlPersistencia;
import utilesDB.utilGen.EncripCad;

public class Controladora {

  ControlPersistencia miControl = new ControlPersistencia();

  public void adiPersona(Persona miPer, String usuCrea) {
    miControl.adiPersona(miPer);
  }

  public List<CodTabla> listTabla(String codTabla) {
    return miControl.listTabla(codTabla);
  }
  
  public Usuario getUsuAlias (String elAlias) {
    return miControl.getUsuAlias (elAlias);
  }

  public Usuario validaUsuAdmin(String valUsuario, String valPassword) {
    Usuario miUsu = getUsuAlias (valUsuario);
    if (miUsu != null) {
      String cadEncri = EncripCad.encrCadII(valPassword);
      if ( miUsu.getUsr_password().equals(cadEncri) ) {
        /**/
      } else  {
        miUsu = null;
      }
    }
    return miUsu;
  }

  public List<Usuario> getUsuFiltro(String strFiltro) {
    return  miControl.getUsuFiltro (strFiltro);
  }

  public void modiUsu(Usuario valUsu) {
    miControl.modiUsu (valUsu);
  }

  public String getNombrePer(Long per_id) {
    Persona miPer = miControl.findPersona (per_id);
    /*********/
    return miPer.getPer_paterno() + " " + miPer.getPer_nombre();
  }

  public String creaUsuPer(String tipDoc, String numDoc, String nomUsu, String patUsu, 
          String matUsu, String aliUsu, String tipUsu, String estUsu, String pasUsu,
          String modCrea, String usuCrea, Usuario unUsu) {
    Usuario miUsu = new Usuario ();
    
    String zMensa = miControl.creaUsuPer(tipDoc, numDoc, nomUsu, patUsu, matUsu, aliUsu, 
            tipUsu, estUsu, pasUsu, modCrea, usuCrea, miUsu);
    return zMensa;
  }

  public Persona getPersona(String tipoDoc, String numDoc) {
    return miControl.buscaCodPer (tipoDoc, numDoc);
  }

  public Persona getPersona(Long per_id) {
    return miControl.getPersona (per_id);
  }

  public Usuario getUsuario(Long idUsuario) {
    return miControl.getUsuario (idUsuario);
  }

  public void elimUsuario(Long idUsuario) {
    miControl.elimUsuario (idUsuario);
  }

  public void modiPersona(Persona perCambio) {
    miControl.modiPersona (perCambio);
  }
      
}
