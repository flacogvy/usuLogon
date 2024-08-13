package utilesDB.utilFecha;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UtlFechas {

  /*Devuelve la FechaHora Actual*/
  public static String getFeHora() {
    String feHora = "";
    Date miFecha = new Date();

    // para el formato AAAAMMDDHHMISS
    SimpleDateFormat miFmt = new SimpleDateFormat("yyyyMMddkkmmss");
    feHora = miFmt.format(miFecha);

    return feHora;
  }

  /*Devuelve la Fecha simple actual*/
  public static String getFecha() {
    Date miFecha = new Date();
    SimpleDateFormat miFmt = new SimpleDateFormat("yyyyMMdd");
    String fecha = miFmt.format(miFecha);
    return fecha;
  }

  /*Devuelve la Hora Actual*/
  public static String getHora() {
    Date miFecha = new Date();
    SimpleDateFormat miFmt = new SimpleDateFormat("kkmmss");
    String hora = miFmt.format(miFecha);
    return hora;
  }

  /*Devuelve la hora en formato HH:MM:SS*/
  public static String getHorFmt() {
    Date miFecha = new Date();
    SimpleDateFormat miFmt = new SimpleDateFormat("kk:mm:ss");
    String hora = miFmt.format(miFecha);
    return hora;
  }
  
  /*Suma dias a una fecha en formato YYYYMMDD*/
  public static String sumDias(String unaFecha, int numDias) {
    if (numDias == 0) {
      return unaFecha;
    }
    Calendar miCal = Calendar.getInstance();
    Date miDate = new Date();
    SimpleDateFormat sdFmt = new SimpleDateFormat("yyyyMMdd");
    try {
      miDate = sdFmt.parse(unaFecha);
    } catch (ParseException e) {
      e.printStackTrace();
      return "F";
    }
    miCal.setTime(miDate);
    miCal.add(Calendar.DAY_OF_YEAR, numDias);
    miDate = miCal.getTime();
    return sdFmt.format(miDate);
  }
  
  /*Suma Dias Habiles a una fecha*/
  public static String sumDiaHabil (String unaFecha, int numDias) {
    
    return "";
  }

}
