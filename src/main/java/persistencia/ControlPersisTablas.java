package persistencia;

public class ControlPersisTablas {
  
  private CodTablaJpaController controlTablas = new CodTablaJpaController();

  public String getDescTabla(String cdTablax, String codItemx) {
    return controlTablas.getDescTabla (cdTablax, codItemx);
  }
  
  
  
}
