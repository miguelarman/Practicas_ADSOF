package cine;

import java.util.*;

/**
 * Clase Sala. Almacena una lista de sesiones que se desarrollaran en la sala,
 * ademas de el numero de butacas de la sala y un identificador para distinguir
 * unas salas de otras.
 * 
 * @author Miguel Arconada (miguel.arconada@estudiante.uam.es) y Alberto
 *         Gonzalez (alberto.gonzalezk@estudiante.uam.es)
 *
 */

public class Sala {

	/**
	 * Contador necesario para asignar los identificadores a las salas
	 */
	private static int contador = 0;

	/**
	 * Identificador de la sala
	 */
	private int identificador;

	/**
	 * Numero de butacas de la sala
	 */
	private int butacas;

	/**
	 * Lista de sesiones a proyectar en la sala
	 */
	private List<Sesion> sesiones;

	/**
	 * Constructor de la clase Sala.
	 * 
	 * @param butacas Numero de butacas de la sala
	 */
	public Sala(int butacas) {
		this.butacas = butacas;
		contador++;
		identificador = contador;
		this.sesiones = new ArrayList<Sesion>();
	}

	// Getters

	/**
	 * Metodo getter de identificador
	 * 
	 * @return Identificador de la sala
	 */
	public int getIdentificador() {
		return identificador;
	}

	/**
	 * Metodo getter de contador
	 * 
	 * @return Contador de la sala
	 */
	public static int getContador() {
		return contador;
	}

	/**
	 * Metodo getter de butacas
	 * 
	 * @return Numero de butacas de la sala
	 */
	public int getButacas() {
		return butacas;
	}

	/**
	 * Metodo getter de sesiones
	 * 
	 * @return Sesiones de la sala
	 */
	public List<Sesion> getSesiones() {
		return sesiones;
	}

	// Setters

	/**
	 * Metodo setter de butacas
	 * 
	 * @param butacas Numero de butacas
	 */
	public void setButacas(int butacas) {
		this.butacas = butacas;
	}

	/**
	 * Anade una sesion dada a la lista de sesiones de la sala. Ademas comprueba que
	 * no se solapen en el tiempo.
	 * 
	 * @param sesion Sesion a anadir
	 * @return Valor booleano que representa
	 *         <ul>
	 *         <li>True si se ha realizado correctamente</li>
	 *         <li>False en cualquier otro caso</li>
	 *         </ul>
	 */
	public Boolean anadirSesion(Sesion sesion) {

		if (sesion == null) {
			return false;
		}

		for (Sesion sesionAux : sesiones) {

			Boolean valido = true;

			/*
			 * Comprobamos que no se solapa con las peliculas existentes - No empieza en
			 * mitad de una pelicula - No termina en mitad de una pelicula - No abarca una
			 * pelicula entera
			 */
			if (sesion.getFecha().after(sesionAux.getFecha()) && sesion.getFecha().before(sesionAux.finalSesion())) {
				valido = false;
			} else if (sesion.finalSesion().after(sesionAux.getFecha())
					&& sesion.finalSesion().before(sesionAux.finalSesion())) {
				valido = false;
			} else if (sesion.getFecha().before(sesionAux.getFecha())
					&& sesion.finalSesion().after(sesionAux.finalSesion())) {
				valido = false;
			}

			if (!valido) {
				return false;
			}

			if (sesionAux == sesion) {
				return true;
			}
		}

		sesiones.add(sesion);

		return true;
	}

	/**
	 * Metodo que elimina una sesion de la sala
	 * 
	 * @param sesion
	 *            Sesion que se desea eliminar
	 * @return Valor booleano:
	 *         <ul>
	 *         <li>True si se ha podido eliminar la sesion</li>
	 *         <li>False si no se ha podido eliminar la sesion</li>
	 *         </ul>
	 */
	public boolean removeSesion(Sesion sesion) {

		for (Sesion se : this.sesiones) { // Busca la sesion a eliminar
			if (sesion == se) {
				this.sesiones.remove(se);

				return true;
			}
		}

		return false;
	}

	// toString

	@Override
	/**
	 * Metodo toString, necesario para imprimir por pantalla y para llamar a
	 * toString de otras clases
	 * 
	 * @return la cadena con la informacion sobre la sala
	 */
	public String toString() {
		String cadena = "Sala " + identificador + ":\n" + "Número de butacas: " + butacas + "\n" + "Sesiones:\n";
		int i = 1;
		for (Sesion s : sesiones) {
			cadena += "\n(" + i + ")\n";
			cadena += s.toString();
			i++;
		}
		return cadena;
	}

}
