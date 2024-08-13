package utilesDB.utilGen;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EncripCad {
  
  public static String encrCadII (String strBase) {
    String strSal= "";
    try {
      MessageDigest miDigest = MessageDigest.getInstance("SHA-256");
      byte [] misBytes = miDigest.digest(strBase.getBytes());
      //convertir a hexadecimal
      StringBuilder strHex = new StringBuilder();
      for (byte b : misBytes) {
        strHex.append(String.format("%02x", b));
      }
      strSal = strHex.toString();
    } catch (NoSuchAlgorithmException ex) {
      Logger.getLogger(EncripCad.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return strSal;
  }
  
  public static String encrCadIII (String strBase) {
    String strSal= "";
    try {
      MessageDigest miDigest = MessageDigest.getInstance("SHA-512");
      byte [] misBytes = miDigest.digest(strBase.getBytes());
      //convertir a hexadecimal
      StringBuilder strHex = new StringBuilder();
      for (byte b : misBytes) {
        strHex.append(String.format("%02x", b));
      }
      strSal = strHex.toString();
    } catch (NoSuchAlgorithmException ex) {
      Logger.getLogger(EncripCad.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return strSal;
  }
}
