/**
 * --------------------------------
 * Clase Fecha
 * 
 * @author Laura
 * Fecha: 29/01/2021
 * --------------------------------
 * Crea una clase Fecha. Los objetos de la clase Fecha son fechas de tiempo y se crean de la forma:
 * 
 * Fecha f = Fecha(1, 10, 2020);
 * 
 * donde los parámetros que se le pasan al constructor son el día, el mes y el año respectivamente.
 * Si la fecha creada es incorrecta mostraremos un mensaje de error en la salida estándar de errores
 * (lo ideal sería lanzar una excepción, ya lo haremos cuando se vea en clase).
 * 
 * Crea métodos para:
 * 
 * Saber si la fecha almacenada es correcta. Sumar y restar días a la fecha. Comparar la fecha almacenada con otra,
 * el método devolverá un valor negativo si la fecha almacenada es ANTERIOR a la otra, 0 si son IGUALES y un valor positivo si es POSTERIOR.
 * Saber si el año de la fecha almacenada es bisiesto.
 * El método toString() devuelve una cadena con el formato "<día del mes> de <nombre del mes> de <año>".
 * 
 * Las opciones a partir de la segunda, solo se realizarán si la fecha almacenada es correcta,
 * en caso de no serlo, se dará un aviso, por la salida estándar de errores, de que la operación no se puede realizar.
 * 
 * Puedes usar una variable de clase para almacenar el número de días de cada mes del año (que no sea bisiesto).
 */

package tanda1POO;

public class Fecha {

  private int dia;
  private int mes;
  private int anio;
  private int[] meses31 = {1, 3, 5, 7, 8, 10, 12};
  private int[] meses30 = {4, 6, 9, 11};


  // constructor

  public Fecha(int dia, int mes, int anio) {
    this.dia = dia;
    this.mes = mes;
    this.anio = anio;
  }

  // getters y setters

  public int getDia() {
    return dia;
  }

  public void setDia(int dia) {
    this.dia = dia;
  }

  public int getMes() {
    return mes;
  }

  public void setMes(int mes) {
    this.mes = mes;
  }

  public int getAnio() {
    return anio;
  }

  public void setAnio(int anio) {
    this.anio = anio;
  }

  // métodos

  /**
   * Comprueba si el año es bisiesto o no
   * 
   * @return true si el año es bisiesto, false si no lo es
   */

  public boolean esBisiesto() {
    if (this.anio % 4 == 0) {
      if (this.anio % 100 == 0 && this.anio % 400 == 0) {
        return true;
      } else {
        if (this.anio % 100 == 0) {
          return false;
        }
      }
    } else {
      return false;
    }

    return true;
  }

  /**
   * Comprueba si el mes está en el array de meses
   * 
   * @param meses array de meses (30 o 31 dias)
   * @param mes mes que se quiere comprobar si está en el array
   * @return true si está en el array, false si no lo está
   */

  public boolean contiene(int[] meses, int mes) {
    for (int i : meses) {
      if (i == mes) {
        return true;
      }
    }
    return false;
  }

  /**
   * Comprueba si la fecha es correcta
   * 
   * @return true si la fecha es correcta, false si no lo es
   */

  public boolean fechaCorrecta() {

    if (this.mes > 12 || this.mes < 1) {
      return false;
    }
    if (this.dia > 31 || this.dia < 1) {
      return false;
    }

    // febrero

    if (this.mes == 2 && this.dia > 28 && esBisiesto() == false) {
      return false;
    }
    if (this.mes == 2 && this.dia > 29 && esBisiesto()) {
      return false;
    }

    // meses de 30 dias

    if (contiene(meses30, this.mes) && this.dia > 30) {
      return false;
    }

    return true;
  }

  /**
   * Suma dias a la fecha almacenada
   * 
   * @param dias dias que se le quieren sumar a la fecha almacenada
   */

  public void sumarDias(int dias) {
    if (fechaCorrecta()) {
      for (int i = 0; i < dias; i++) {
        if (this.mes == 2 && esBisiesto() && this.dia == 29) {
          this.mes++;
          this.dia = 0;
        }
        if (this.mes == 2 && esBisiesto() == false && this.dia == 28) {
          this.mes++;
          this.dia = 0;
        }
        if (contiene(meses30, this.mes) && this.dia == 30) {
          this.mes++;
          this.dia = 0;
        }
        if (contiene(meses31, this.mes) && this.dia == 31) {
          if (this.mes == 12) {
            this.mes = 0;
            this.anio++;
          }
          this.mes++;
          this.dia = 0;
        }
        this.dia++;
      }
    } else {
      System.err.println("Los datos son incorrectos, no se puede realizar la operación.");
    }
  }

  /**
   * Resta dias a la fecha almacenada
   * 
   * @param dias dias que se le quieren restar a la fecha almacenada
   */

  public void restarDias(int dias) {
    if (fechaCorrecta()) {
      for (int i = 0; i < dias; i++) {
        if (this.mes == 3 && esBisiesto() && this.dia == 1) {
          this.mes--;
          this.dia = 30;
        }
        if (this.mes == 3 && esBisiesto() == false && this.dia == 1) {
          this.mes--;
          this.dia = 29;
        }
        if (contiene(meses30, this.mes) && this.dia == 1) {
          this.mes--;
          this.dia = 32;
        }
        if (contiene(meses31, this.mes) && this.dia == 1) {
          this.dia = 31;
          if (this.mes == 1) {
            this.dia = 32;
            this.mes = 13;
            this.anio--;
          }
          if (this.mes == 8) {
            this.dia = 32;
          }
          this.mes--;
        }
        this.dia--;
      }
    } else {
      System.err.println("Los datos son incorrectos, no se puede realizar la operación.");
    }
  }

  /**
   * Compara dos fechas
   * 
   * @param fecha la fecha que se quiere comparar con la fecha almacenada
   * @return 1 si la fecha almacenada es mayor que la otra
   * @return -1 si la fecha almacenada es menor que la otra
   * @return 0 si las fechas son iguales
   */

  public int compararFechas(Fecha fecha) {
    if (this.fechaCorrecta() && fecha.fechaCorrecta()) {
      if (this.anio < fecha.anio) {
        return -1;
      } else {
        if (this.anio > fecha.anio) {
          return 1;
        } else {
          if (this.mes < fecha.mes) {
            return -1;
          } else {
            if (this.mes > fecha.mes) {
              return 1;
            } else {
              if (this.dia < fecha.dia) {
                return -1;
              } else {
                if (this.dia > fecha.dia) {
                  return 1;
                } else {
                  return 0;
                }
              }
            }
          }
        }
      }

    } else {
      System.err.println("Los datos son incorrectos, no se puede realizar la operación.");
    }
    return 100;
  }


  // impresion
  @Override
  public String toString() {
    return this.dia + " de " + this.mes + " de " + this.anio;
  }
}
