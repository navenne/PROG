/** 
* --------------------------------
* Clase Tiempo
* 
* @author Laura
* Fecha: 29/01/2021
* --------------------------------
* Los objetos de la clase Tiempo son intervalos de tiempo y se crean de la forma:
* t = Tiempo(1, 20, 30)
* donde los parámetros que se le pasan al constructor son las horas, los minutos y los segundos respectivamente. 
* Crea métodos para:
* Sumar y restar otro objeto de la clase Tiempo (el resultado es otro objeto).
* Sumar y restar segundos, minutos y/o horas (se cambia el objeto actual).
* Devolver una cadena con el tiempo almacenado, de forma que si lo que hay es (10 35 5) la cadena sea 10h 35m 5s.
*/

package tanda1POO;

public class Tiempo {

  private int horas;
  private int minutos;
  private int segundos;

  // constructores
  public Tiempo(int horas, int minutos, int segundos) {
    this.horas = horas;
    this.minutos = minutos;
    this.segundos = segundos;
  }

  public Tiempo() {}

  // getters y setters
  public int getHoras() {
    return horas;
  }

  public void setHoras(int horas) {
    this.horas = horas;
  }

  public int getMinutos() {
    return minutos;
  }

  public void setMinutos(int minutos) {
    this.minutos = minutos;
  }

  public int getSegundos() {
    return segundos;
  }

  public void setSegundos(int segundos) {
    this.segundos = segundos;
  }

  // metodos

  /**
   * Pasa un objeto Tiempo a segundos
   *
   * @param t tiempo que se va a pasar a segundos
   */
  public static int pasarASegundos(Tiempo t) {
    return t.horas * 3600 + t.minutos * 60 + t.segundos;
  }

  /**
   * Suma otro objeto de la clase Tiempo (el resultado es otro objeto).
   *
   * @param t1 tiempo 1 en segundos que se va a sumar
   * @param t2 tiempo 2 en segundos que se va a sumar
   */
  public static Tiempo sumarObjeto(Tiempo t1, Tiempo t2) {
    int segundos;
    Tiempo t = new Tiempo(0, 0, 0);
    segundos = pasarASegundos(t1) + pasarASegundos(t2);
    t.horas = segundos / 3600;
    t.minutos = (segundos % 3600) / 60;
    t.segundos = (segundos % 3600) % 60;
    return t;
  }

  /**
   * Resta otro objeto de la clase Tiempo (el resultado es otro objeto)
   *
   * @param t1 tiempo 1 en segundos que se va a restar
   * @param t2 tiempo 2 en segundos que se va a restar
   */
  public static Tiempo restarObjeto(Tiempo t1, Tiempo t2) {
    int segundos;
    Tiempo t = new Tiempo(0, 0, 0);
    segundos = pasarASegundos(t1) - pasarASegundos(t2);
    t.horas = segundos / 3600;
    t.minutos = (segundos % 3600) / 60;
    t.segundos = (segundos % 3600) % 60;
    return t;
  }

  /**
   * Suma segundos, minutos y/o horas (se cambia el objeto actual)
   *
   * @param t objeto tiempo que se va a sumar
   */
  public static Tiempo sumar(Tiempo t, int h, int m, int s) {
    int horas = t.horas + h;
    int minutos = t.minutos + m;
    int segundos = t.segundos + s;
    if (segundos > 59) {
      minutos += segundos / 60;
      segundos %= 60;
    }
    if (minutos > 59) {
      horas += minutos / 60;
      minutos %= 60;
    }
    t.setHoras(horas);
    t.setMinutos(minutos);
    t.setSegundos(segundos);
    return t;
  }

  /**
   * Resta segundos, minutos y/o horas (se cambia el objeto actual)
   *
   * @param t objeto tiempo que se va a restar
   */
  public static Tiempo restar(Tiempo t, int h, int m, int s) {
    int horas = t.horas - h;
    int minutos = t.minutos - m;
    int segundos = t.segundos - s;
    if (segundos < 0) {
      segundos = 0;
    }
    if (minutos < 0) {
      minutos = 0;
    }
    if (horas < 0) {
      horas = 0;
    }
    t.setHoras(horas);
    t.setMinutos(minutos);
    t.setSegundos(segundos);
    return t;
  }

  // impresion
  @Override
  public String toString() {
    return this.horas + "h " + this.minutos + "m " + this.segundos + "s";
  }
}
