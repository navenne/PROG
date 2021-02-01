package tanda1POO;

public class TestTiempo {

  public static void main(String args[]) {

    Tiempo t1 = new Tiempo(23, 59, 30);
    Tiempo t2 = new Tiempo(10, 52, 30);

    System.out.println("Tiempo 1");
    System.out.println(t1);
    System.out.println("Tiempo 2");
    System.out.println(t2);
    System.out.println("Suma Tiempo 1 + Tiempo 2");
    System.out.println(Tiempo.sumarObjeto(t1, t2));
    System.out.println("Resta Tiempo 1 - Tiempo 2");
    System.out.println(Tiempo.restarObjeto(t1, t2));
    System.out.println("Suma a Tiempo 1, horas, minutos y segundos");
    System.out.println(Tiempo.sumar(t1, 1, 2, 3));
    System.out.println("Resta a Tiempo 1, horas, minutos y segundos");
    System.out.println(Tiempo.restar(t1, 1, 2, 3));
  }

}
