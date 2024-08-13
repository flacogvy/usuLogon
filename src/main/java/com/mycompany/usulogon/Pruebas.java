package com.mycompany.usulogon;

import java.util.ArrayList;
import java.util.List;
import logica.CodTabla;
import logica.Controladora;
import logica.Persona;
import logica.Usuario;
import utilesDB.utilGen.EncripCad;

public class Pruebas {
  public static void main(String[] args) {
    
    Controladora mioControl = new Controladora();
    
    Persona miPer = new Persona(10L, "CI", "78744", "FEDERICO", "ARCE", "PEREZ", 
            "20001011", "121232", "ACT", "MAS", "", "", "", 
            "", "", "");
    
    /*System.out.println("INVOCANDO CREACION");
    mioControl.adiPersona (miPer, "USUARIO");
    
    System.out.println("FIN CREACION");*/
    
    //LIstado de tablas 
    String miCod = "ECI";
    List <CodTabla> miLista = mioControl.listTabla(miCod);
    ArrayList<CodTabla> lisReal = new ArrayList(miLista);
    System.out.println("*************");
    for (CodTabla miTabla : lisReal) {
      System.out.println("Elemnto: " + miTabla.getCtaOpcion() + "-" + 
              miTabla.getCtaDescripcion());
    }
    
    /*******OTRA PRUEBA ********/
    Usuario miUsu = null; 
    
    miUsu = mioControl.getUsuAlias("PEEP");
    
    if (miUsu != null) {
      System.out.println("USUARIO RECUPERADO: " + miUsu.toString());
      } else {
      System.out.println("ALIAS NO REGISTRADO");
    }
    
    String clave="YMANUEL";
    String decrip = EncripCad.encrCadII (clave);
    System.out.println("la Clave: " + clave);
    System.out.println("encroptado :" + decrip);
    

    
    
  }
  
  
  
  
}
