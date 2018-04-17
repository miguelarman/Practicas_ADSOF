package terminales;

import interfaces.INodo;

/**
 * Clase que implementa los terminales de tipo aritmetico
 * 
 * @author Miguel Arconada (miguel.arconada@estudiante.uam.es) Alberto Gonzalez (alberto.gonzalezk@estudiante.uam.es)
 */
public class TerminalAritmetico extends Terminal {
	
	/**
	 * Valor con el que calcular el valor de un individuo. Es estatico para
	 * facilitar el calculo del fitness para el algoritmo genetico
	 */
	private static Integer valor;

	/**
	 * Constructor de la clase TerminalAritmetico
	 * 
	 * @param raiz Simbolo del terminal
	 */
	public TerminalAritmetico(String raiz) {
		super(raiz);
	}

	@Override
	public INodo copy() {
		TerminalAritmetico copy = new TerminalAritmetico(this.getRaiz());
		copy.setPadre(this.getPadre());
		copy.actualizarPadres();
		return copy;
	}
	
	/**
	 * Metodo setter del campo estatico valor. Con este metodo se cambia para evaluarlo en diferentes puntos
	 * 
	 * @param i Nuevo valor
	 */
	public static void setValor(Integer i) {
		TerminalAritmetico.valor = i;
	}

	@Override
	public String toString() {
		return this.getRaiz();
	}

	@Override
	public double calcular() {
		return TerminalAritmetico.valor;
	}

}
