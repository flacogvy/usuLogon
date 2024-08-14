package logica;

import persistencia.ControlPersisTablas;


public class ControlCodTabla {
  
  private static ControlPersisTablas locControl = new ControlPersisTablas();
  
  public static String getDescTabla (String codTabla, String CodItem)  {
    return locControl.getDescTabla (codTabla, CodItem);
    //return "";
  }
  
}
