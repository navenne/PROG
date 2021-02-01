/**
  * --------------------------------
  * Clase Fraccion
  * @author Laura
  * Fecha: 29/01/2021
  * --------------------------------
  * Enunciado: 
  * Crea una clase Fraccion de forma que podamos hacer las siguientes operaciones:
  * Contruir un objeto Fraccion pasándole el numerador y el denominador.
  * Obtener la fracción como cadena de caracteres.
  * Obtener y modificar numerador y denominador. No se puede dividir por cero.
  * Obtener resultado de la fracción (número real).
  * Multiplicar la fracción por un número entero (el resultado es otro objeto fracción).
  * Multiplicar, sumar y restar fracciones (el resultado es otro objeto fracción).
  * Simplificar la fracción (cambia el objeto actual).
  */

package tanda1POO;

public class Fraccion {
	
	private int numerador;
	private int denominador;
	
	//constructor
	
	public Fraccion(int numerador, int denominador) {
		this.numerador = numerador;
		this.setDenominador(denominador);
	}
	
	//getters y setters
	
	public Fraccion() {
	}

	public int getNumerador() {
		return numerador;
	}

	public void setNumerador(int numerador) {
		this.numerador = numerador;
	}

	public int getDenominador() {
		return denominador;
	}

	public void setDenominador(int denominador) {
		this.denominador = denominador;
		
		if (denominador == 0) {
			System.out.println("El denominador no puede ser cero.");
		}
	}
	
	//impresion
  
	@Override
  public String toString() {
    return this.numerador + " / " + this.denominador;
  }
	
	//métodos
	
	public double resultado() {
		return this.numerador / this.denominador;
	}
	
	public Fraccion multiplicarEntero(int entero) {
		return new Fraccion(this.numerador * entero, this.denominador);
	}
	
	public Fraccion multiplicarFraccion(Fraccion fraccion1) {
		this.numerador *= fraccion1.numerador;
		this.denominador *= fraccion1.denominador;
		return new Fraccion(this.numerador, this.denominador);
	}
	
	public Fraccion sumarFraccion(Fraccion fraccion1) {
		this.numerador = (this.numerador * fraccion1.denominador + fraccion1.numerador * this.denominador);
		this.denominador *= fraccion1.denominador;
		return new Fraccion(this.numerador, this.denominador);
	}
	
	public Fraccion restarFraccion(Fraccion fraccion1) {
		return this.sumarFraccion(fraccion1.multiplicarEntero(-1));
	}
	
	/**
	 * Calcula el máximo común divisor
	 */
	
	private int mcd(){
    int numerador = Math.abs(this.numerador);
    int denominador = Math.abs(this.denominador);
    if (denominador == 0) {
     return numerador;
    }
    int resto;
    while (denominador != 0) {
      resto = numerador % denominador;
         numerador = denominador;
         denominador = resto;
    }
    return numerador;
 }

 public Fraccion simplificarFraccion(){
    int divisor = mcd();
    this.numerador /= divisor;
    this.denominador /= divisor;
    return this;
 }

}
