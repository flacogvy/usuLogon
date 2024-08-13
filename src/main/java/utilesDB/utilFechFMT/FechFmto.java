package utilesDB.utilFechFMT;

public class FechFmto {

  public static String fechaPnt(String fechBase) {
    String fechSal = "";
    fechSal = fechBase.substring(6, 8);

    switch (Integer.parseInt(fechBase.substring(4, 6))) {
      case 1:
        fechSal = fechSal + "ENE";
        break;
      case 2:
        fechSal = fechSal + "FEB";
        break;
      case 3:
        fechSal = fechSal + "MAR";
        break;
      case 4:
        fechSal = fechSal + "ABR";
        break;
      case 5:
        fechSal = fechSal + "MAY";
        break;
      case 6:
        fechSal = fechSal + "JUN";
        break;
      case 7:
        fechSal = fechSal + "JUL";
        break;
      case 8:
        fechSal = fechSal + "AGO";
        break;
      case 9:
        fechSal = fechSal + "SEP";
        break;
      case 10:
        fechSal = fechSal + "OCT";
        break;
      case 11:
        fechSal = fechSal + "NOV";
        break;
      case 12:
        fechSal = fechSal + "DIC";
        break;
    }
    fechSal = fechSal + fechBase.substring(0, 4);
    return fechSal;
  }
  
  public static String feHoraPnt(String laFechahora) {
    String fecSalida = "";
    if (laFechahora.compareTo("") != 0) {
      fecSalida = laFechahora.substring(6, 8);
      switch (Integer.parseInt(laFechahora.substring(4, 6))) {
        case 1:
          fecSalida = fecSalida + "ENE";
          break;
        case 2:
          fecSalida = fecSalida + "FEB";
          break;
        case 3:
          fecSalida = fecSalida + "MAR";
          break;
        case 4:
          fecSalida = fecSalida + "ABR";
          break;
        case 5:
          fecSalida = fecSalida + "MAY";
          break;
        case 6:
          fecSalida = fecSalida + "JUN";
          break;
        case 7:
          fecSalida = fecSalida + "JUL";
          break;
        case 8:
          fecSalida = fecSalida + "AGO";
          break;
        case 9:
          fecSalida = fecSalida + "SEP";
          break;
        case 10:
          fecSalida = fecSalida + "OCT";
          break;
        case 11:
          fecSalida = fecSalida + "NOV";
          break;
        case 12:
          fecSalida = fecSalida + "DIC";
          break;
      }
      fecSalida = fecSalida + laFechahora.substring(0, 4) + " ";
      fecSalida = fecSalida + laFechahora.substring(8, 10) + ":" +
              laFechahora.substring(10, 12) + ":" + laFechahora.substring(12, 14);
    }
    return fecSalida;
  }

}
