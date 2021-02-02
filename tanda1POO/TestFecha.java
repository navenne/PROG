package tanda1POO;

public class TestFecha {

  public static void main(String args[]) {
    Fecha fecha1 = new Fecha(1, 10, 1999);
    Fecha fecha2 = new Fecha(1, 3, 2000);
    Fecha fecha3 = new Fecha(3, 12, 2004);
    Fecha fecha4 = new Fecha(1, 8, 2001);

    if (fecha1.esBisiesto()) {
      System.out.println("El año " + fecha1.getAnio() + " es bisiesto");
    } else {
      System.out.println("El año " + fecha1.getAnio() + " no es bisiesto");
    }

    if (fecha2.esBisiesto()) {
      System.out.println("El año " + fecha2.getAnio() + " es bisiesto");
    } else {
      System.out.println("El año " + fecha2.getAnio() + " no es bisiesto");
    }

    if (fecha3.esBisiesto()) {
      System.out.println("El año " + fecha3.getAnio() + " es bisiesto");
    } else {
      System.out.println("El año " + fecha3.getAnio() + " no es bisiesto");
    }

    fecha2.restarDias(1);
    System.out.println("Le restamos 1 día a la fecha 01/03/2000: " + fecha2);

    fecha3.sumarDias(29);
    System.out.println("Le sumamos 29 días a la fecha 03/12/2004: " + fecha3);

    fecha4.restarDias(1);
    System.out.println("Le restamos 1 día a la fecha 01/08/2001: " + fecha4);

    if (fecha1.compararFechas(fecha2) == 1) {
      System.out.println("La fecha " + fecha1 + " es posterior a la fecha " + fecha2);
    } else {
      if (fecha1.compararFechas(fecha2) == -1) {
        System.out.println("La fecha " + fecha1 + " es anterior a la fecha " + fecha2);
      } else {
        if (fecha1.compararFechas(fecha2) == 0) {
          System.out.println("Las fechas son iguales");
        }
      }
    }
  }
}
