/**
 * 
 */
package cine;

import java.util.Calendar;

/**
 * Esta clase extiende la clase Entrada, con la diferencia de que tiene un
 * atributo de un descuento, por lo que el precio se calcula de manera diferente
 * 
 * @author Miguel Arconada (miguel.arconada@estudiante.uam.es) Alberto Gonzalez
 *         (alberto.gonzalezk@estudiante.uam.es)
 *
 */
public class EntradaDiaEspectador extends Entrada {

	/**
	 * Descuento aplicado si la entrada es del dia del espectador. Es estatico, pues
	 * es el mismo para todas las entradas
	 */
	private static Float descuento = (float) 0.3;

	/**
	 * Metodo constructor de la clase EntradaDiaEspectador
	 * 
	 * @param sesion Sesion de la que se quiere entrada
	 */
	public EntradaDiaEspectador(Sesion sesion) {
		super(sesion);
	}

	// Getters

	/**
	 * Metodo que calcula el precio de la entrada del precio
	 * 
	 * @return Precio base aplicado el descuento
	 */
	public Float getPrecio() {
		return super.getPrecio() * (1 - descuento);
	}

	// Setters

	/**
	 * Metodo setter del descuento
	 * 
	 * @param descuento_
	 *            Nuevo descuento para las entradas del dia del espectador
	 */
	public static void setDiscount(Float descuento_) {
		descuento = descuento_;
	}

	/**
	 * Metodo que comprueba si cierta fecha es un dia del espectador
	 * 
	 * @param fecha
	 *            Fecha que se quiere comprobar
	 * @return Valor booleano
	 *         <ul>
	 *         <li>True si el dia es valido como dia del espectador</li>
	 *         <li>False si el dia no es valido como dia del espectador</li>
	 *         </ul>
	 */
	public static Boolean isFechaEspectador(Calendar fecha) {

		int dayOfWeek = fecha.get(Calendar.DAY_OF_WEEK);

		if (dayOfWeek == Calendar.WEDNESDAY) {
			return true;
		} else {
			return false;
		}
	}

	// toString

	@Override
	/**
	 * Metodo toString de la clase EntradaDiaEspectador. Necesario para imprimir por
	 * pantalla una entrada en formato legible
	 * 
	 * @return Cadena imprimible con los datos de la entrada
	 */
	public String toString() {
		String cadena = "";

		cadena += "Entrada (id: " + this.getIdentificador() + ") para la sesion:\n" + this.getSesion() + "Precio: "
				+ this.getPrecio() + "\n";

		return cadena;
	}
}
