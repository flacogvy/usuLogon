package utilesDB.utilFecha;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class UtlFecTime {

  /*Obtiene la fecha hora del sistema*/
  public static String getFeHora() {
    String miFecha = "";
    LocalDateTime fecHoy = LocalDateTime.now();
    miFecha = fecHoy.getYear() + "";
    switch (fecHoy.getMonthValue()) {
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
        miFecha = miFecha + "0" + fecHoy.getMonthValue();
        break;
      default:
        miFecha = miFecha + fecHoy.getMonthValue();
    }

    switch (fecHoy.getDayOfMonth()) {
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
        miFecha = miFecha + "0" + fecHoy.getDayOfMonth();
        break;
      default:
        miFecha = miFecha + fecHoy.getDayOfMonth();
    }

    switch (fecHoy.getHour()) {
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
        miFecha = miFecha + "0" + fecHoy.getHour();
        break;
      default:
        miFecha = miFecha + fecHoy.getHour();
    }
    switch (fecHoy.getMinute()) {
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
        miFecha = miFecha + "0" + fecHoy.getMinute();
        break;
      default:
        miFecha = miFecha + fecHoy.getMinute();
    }

    switch (fecHoy.getSecond()) {
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
        miFecha = miFecha + "0" + fecHoy.getSecond();

        break;
      default:
        miFecha = miFecha + fecHoy.getSecond();
    }

    return miFecha;
  }

  public static String getFecha() {
    String miFecha = "";
    LocalDate fecHoy = LocalDate.now();
    //Año
    miFecha = fecHoy.getYear() + "";
    //Mes
    switch (fecHoy.getMonthValue()) {
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
        miFecha = miFecha + "0" + fecHoy.getMonthValue();
        break;
      default:
        miFecha = miFecha + "0" + fecHoy.getMonthValue();
    }
    //Dia

    switch (fecHoy.getDayOfMonth()) {
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
        miFecha = miFecha + "0" + fecHoy.getDayOfMonth();
        break;
      default:
        miFecha = miFecha + fecHoy.getDayOfMonth();
    }

    return miFecha;
  }

  public static String getHora() {
    String miHora = "";
    LocalTime horAct = LocalTime.now();
    switch (horAct.getHour()) {
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
        miHora = "0" + horAct.getHour();
        break;
      default:
        miHora = "" + horAct.getHour();
    }

    //minutos
    switch (horAct.getMinute()) {
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
        miHora = miHora + "0" + horAct.getMinute();
        break;
      default:
        miHora = miHora + horAct.getMinute();
    }
    //segundos
    switch (horAct.getSecond()) {
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
        miHora = miHora + "0" + horAct.getSecond();
        break;
      default:
        miHora = miHora + horAct.getSecond();
    }

    return miHora;
  }

  public static String getHorFmt() {
    String miHora = "";
    LocalTime horAct = LocalTime.now();
    switch (horAct.getHour()) {
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
        miHora = "0" + horAct.getHour();
        break;

      default:
        miHora = "" + horAct.getHour();

    }

    miHora = miHora + ":";
    //minutos
    switch (horAct.getMinute()) {
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
        miHora = miHora + "0" + horAct.getMinute();
        break;
      default:
        miHora = miHora + horAct.getMinute();
    }

    miHora = miHora + ":";

    //segundos
    switch (horAct.getSecond()) {
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
        miHora = miHora + "0" + horAct.getSecond();
        break;
      default:
        miHora = miHora + horAct.getSecond();
    }

    return miHora;
  }

  public static String sumDias(String fecBase, int diasSum) {
    String laNewFecha = "";
    LocalDate miFecha = null;
    try {
      miFecha = LocalDate.of(Integer.parseInt(fecBase.substring(0, 4)),
              Integer.parseInt(fecBase.substring(4, 6)),
              Integer.parseInt(fecBase.substring(6, 8)));
    } catch (DateTimeException e) {
      e.printStackTrace();
      return "F";
    }

    miFecha = miFecha.plusDays(diasSum);

    // año
    laNewFecha = miFecha.getYear() + "";

    //Mes
    switch (miFecha.getMonthValue()) {
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
        laNewFecha = laNewFecha + "0" + miFecha.getMonthValue();
        break;
      default:
        laNewFecha = laNewFecha + miFecha.getMonthValue();
    }

    //dia
    switch (miFecha.getDayOfMonth()) {
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
        laNewFecha = laNewFecha + "0" + miFecha.getDayOfMonth();
        break;
      default:
        laNewFecha = laNewFecha + miFecha.getDayOfMonth();
    }

    return laNewFecha;

  }

}
