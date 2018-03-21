package cine;

import java.util.*;

/**
 * Clase Sala. Almacena una lista de sesiones que se desarrollaran en la sala, ademas de el numero de butacas de la sala y un identificador para distinguir unas salas de otras.
 * @author Miguel Arconada (miguel.arconada@estudiante.uam.es) y Alberto Gonzalez (alberto.gonzalezk@estudiante.uam.es) 
 *
 */

public class Sala {

	private static int contador = 0;
	private int identificador;
	private int butacas;
	private List<Sesion> sesiones;
	
	/**
	 * Constructor de la clase Sala.
	 * @param butacas
	 */

	public Sala(int butacas) {
		this.butacas = butacas;
		contador++;
		identificador = contador;
		this.sesiones = new ArrayList<Sesion>();
	}
	
	/**
	 * Metodo getter de identificador
	 * @return Identificador de la sala
	 */

	public int getIdentificador() {
		return identificador;
	}
	
	/**
	 * Metodo getter de contador
	 * @return Contador de la sala
	 */

	public static int getContador() {
		return contador;
	}
	
	/**
	 * Metodo getter de butacas
	 * @return Numero de butacas de la sala
	 */

	public int getButacas() {
		return butacas;
	}
	
	/**
	 * Metodo getter de sesiones
	 * @return Sesiones de la sala
	 */

	public List<Sesion> getSesiones() {
		return sesiones;
	}
	
	/**
	 * Metodo setter de butacas
	 * @param butacas
	 */

	public void setButacas(int butacas) {
		this.butacas = butacas;
	}
	
	/**
	 * Anade una sesion dada a la lista de sesiones de la sala. Ademas comprueba que no se solapen en el tiempo.
	 * @param sesion
	 * @return true si la sesion se ha añadido correctamente y false si no
	 */

	public Boolean anadirSesion(Sesion sesion) {
		for (Sesion sesionAux : sesiones) {
			if (sesionAux.finalSesion().after(sesion.getFecha()) || sesionAux.equals(sesion)) {
				return false;
			}
		}

		sesiones.add(sesion);

		return true;
	}
	
	/**
	 * Metodo toString, necesario para imprimir por pantalla y para llamar a toString de otras clases 
	 * @return la cadena con la informacion sobre la sala
	 */
	@Override
	public String toString() {
		String cadena = "Sala " + identificador + ":\n" + "Número de butacas: " + butacas + "\n" + "Sesiones:\n";
		int i = 1;
		for (Sesion s : sesiones) {
			cadena += "\n" + i + ":\n\n";
			cadena += s.toString();
			i++;
		}
		return cadena;
	}


}
