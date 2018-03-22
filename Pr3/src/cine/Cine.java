package cine;

import java.util.*;

/**
 * @author Miguel Arconada (miguel.arconada@estudiante.uam.es) Alberto Gonzalez (alberto.gonzalezk@estudiante.uam.es)
 *
 */
public class Cine {
	/**
	 * Nombre del cine
	 */
	private String nombre;
	
	/**
	 * Direccion del cine
	 */
	private String direccion;
	
	/**
	 * Cartelera del cine
	 */
	private List<Pelicula> listaPeliculas;
	
	/**
	 * Lista de salas del cine
	 */
	private List<Sala> listaSalas;
	
	/**
	 * Lista de entradas del cine
	 */
	private List<Entrada> listaEntradas;
	
	/**
	 * 
	 * @param nombre del cine
	 * @param direccion del cine
	 */
	public Cine(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.listaPeliculas = new ArrayList<Pelicula>();
		this.listaEntradas = new ArrayList<Entrada>();
		this.listaSalas = new ArrayList<Sala>();
	}

	/**
	 * Metodo getter de nombre
	 * @return nombre del cine
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo getter de direccion
	 * @return direccion del cine
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Metodo getter de lista de peliculas
	 * @return cartelera
	 */
	public List<Pelicula> getListaPeliculas() {
		return listaPeliculas;
	}

	/**
	 * Metodo getter de lista de entradas
	 * @return lista de entradas
	 */
	public List<Entrada> getListaEntradas() {
		return listaEntradas;
	}
	
	/**
	 * Metodo getter de lista de salas
	 * @return lista de salas
	 */
	public List<Sala> getListaSalas() {
		return listaSalas;
	}

	/**
	 * Metodo setter de nombre
	 * @param nombre del cine
	 *  
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo setter de direccion
	 * @param nombre del cine	 *  
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Anade una pelicula a la lista de peliculas del cine
	 * @param pelicula
	 * @return Valor booleano que representa <ul>
	 * <li>True si se ha realizado correctamente</li>
	 * <li>False en cualquier otro caso</li>
	 * </ul>
	 */
	public Boolean anadirPelicula(Pelicula peli) {
		if(peli == null) {
			return false;
		}
		this.listaPeliculas.add(peli);
		return true;
	}
	
	/**
	 * Anade una sala a la lista de salas del cine
	 * @param sala
	 * @return Valor booleano que representa <ul>
	 * <li>True si se ha realizado correctamente</li>
	 * <li>False en cualquier otro caso</li>
	 * </ul>
	 */
	public Boolean anadirSala(Sala sala) {
		if(sala.getIdentificador() == 0 || sala == null) {
			return false;
		}
		this.listaSalas.add(sala);
		return true;
	}
	
	/**
	 * Anade una entrada a la lista de entradas del cine
	 * @param entrada
	 * @return Valor booleano que representa <ul>
	 * <li>True si se ha realizado correctamente</li>
	 * <li>False en cualquier otro caso</li>
	 * </ul>
	 */
	public Boolean anadirEntrada(Entrada e) {
		if(e.getIdentificador() == 0 || e == null) {
			return false;
		}
		this.listaEntradas.add(e);
		return true;
	}
	
	/**
	 * Si la sesion y la sala estan almacenadas en nuestro cine, cambia la sala de la sesion a la indicada, 
	 * introduce la sesion en la lista de sesiones de la nueva sala y la remueve de la antigua
	 * @param sesion
	 * @param sala
	 * @return Valor booleano que representa <ul>
	 * <li>True si se ha realizado correctamente</li>
	 * <li>False en cualquier otro caso</li>
	 * </ul>
	 */
	public Boolean anadirSesionASala(Sesion sesion, int sala) {
		
		Boolean check;
		
		if (sesion == null || sala <= 0 || sala > Sala.getContador()) {
			return false;
		}
		for (Sala s : listaSalas) { // Recorre la lista de salas para encontrar la que tenga el id
			if (s.getIdentificador() == sala) {
				for (Sala sal : listaSalas) { // Recorre la lista de salas para comprobar si la sesion ya ha sido anadida
					for (Sesion ses : sal.getSesiones()) {
						if (ses == sesion) {
							check = s.anadirSesion(sesion); // Anade la sesion a la lista de sesiones de la nueva sala
							if(check == false) {
								return false;
							}
							check = ses.getSala().getSesiones().remove(sesion); // Quita la sesion de la anterior sala
							if(check == false) {
								return false;
							}
							
							sesion.setSala(s);
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Si la sesion y la sala estan almacenadas en nuestro cine, cambia la pelicula de la sesion a la del parametro de entrada
	 * @param nombre de la pelicula
	 * @param sesion
	 * @return Valor booleano que representa <ul>
	 * <li>True si se ha realizado correctamente</li>
	 * <li>False en cualquier otro caso</li>
	 * </ul>
	 */
	public Boolean anadirPeliculaASesion(String peli, Sesion s) {
		
		if(s == null) {
			return false;
		}

		for (Pelicula p : listaPeliculas) {// Recorre la lista de peliculas para encontrar la que tiene el titulo indicado
			if (p.getTitulo() == peli) {
				for (Sala sala : listaSalas) { // Encuentra la sesion pasada como argumento
					for (Sesion ses : sala.getSesiones()) {
						if (ses == s) {
							s.setPelicula(p);
							return true;
						}
					}
				}

			}
		}

		return false;
	}
	
	/**
	 * Anade una entrada a la lista de entradas, actualizando las butacas vendidas
	 * @param sesion
	 * @return Objeto de la clase entrada que representa <ul>
	 * <li>null si ha habido algun problema</li>
	 * <li>La nueva entrada en cualquier otro caso</li>
	 * </ul>
	 */
	public Entrada venderEntrada(Sesion s) {

		Calendar fecha;
		Entrada entrada;
		
		if(s == null) {
			return null;
		}
		
		fecha = s.getFecha();

		for (Sala sala : listaSalas) {
			for (Sesion ses : sala.getSesiones()) { // Busca la sesion deseada
				if (s == ses) {
					if (EntradaDiaEspectador.isFechaEspectador(fecha)) {
						entrada = new EntradaDiaEspectador(s);
					} else {
						entrada = new Entrada(s);
					}
					
					Boolean check = this.anadirEntrada(entrada);
					if (!check) { // Comprueba que se ha podido anadir la entrada (habia butacas suficientes)
						return null;
					}

					return entrada;

				}
			}
		}
		return null;
	}
	
	/**
	 * Calcula la suma del precio de las entradas vendidas
	 * @return el total recaudado
	 */

	public Float informacionRecaudacion() {

		Float total = (float) 0;

		for (Entrada e : this.listaEntradas) {
			total += e.getPrecio();
		}

		return total;
	}

	/**
	 * Forma una cadena con la informacion de todas las peliculas en la cartelera
	 * @return la informacion de la cartelera
	 */
	public String informacionCartelera() {

		String cadena = "";

		for (Pelicula p : this.listaPeliculas) {
			cadena += "\n" + p;
		}
		return cadena;
	}
	
	/**
	 * Forma una cadena con la informacion de todas las sesiones del cine
	 * @return la informacion de las sesiones
	 */
	public String informacionSesiones() {

		List<Sesion> sesiones = new ArrayList<Sesion>();
		String cadena = "";

		for (Sala s : listaSalas) {
			sesiones.addAll(s.getSesiones());
		}

		for (Sesion se : sesiones) {
			cadena += "\n" + se;
		}

		return cadena;

	}
	
	
	/**
	 * Metodo que eliminar una pelicula de la lista de peliculas del cine
	 * @param titulo Titulo de la pelicula que se desea eliminar
	 * @return Valor entero que representa <ul>
	 * <li>Numero de sesiones que tenian la pelicula eliminada</li>
	 * <li>-1 si no se ha podido eliminar</li>
	 * </ul>
	 */
	public int removePeliculaCartelera(String titulo) {

		int numSesiones = 0;
		Boolean check;

		for (Pelicula p : listaPeliculas) { // Busca la pelicula con el titulo 
			if (titulo == p.getTitulo()) {
				for (Sala s : listaSalas) {
					for (Sesion ses : s.getSesiones()) { // Busca las sesiones con esa pelicula
						if (ses.getPelicula() == p) {
							numSesiones++;
							check = s.getSesiones().remove(ses); // Se eliminan las sesiones con esa pelicula
							if (!check) {
								return -1;
							}
						}
					}
				}
				check = listaPeliculas.remove(p); // Se elimina la pelicula
				if (check == false) {
					return -1;
				}
				return numSesiones;
			}
		}
		return -1;
	}
	
	
	/**
	 * Metodo que elimina una sala del cine
	 * @param id Identificador de la sala que se desea eliminar
	 * @return Valor entero que representa <ul>
	 * <li>Numero de sesiones que tenia la sala eliminada</li>
	 * <li>-1 si no se ha podido eliminar</li>
	 * </ul>
	 */
	public int removeSala(int id) {
		int numSesiones = 0;
		Boolean check;

		if (Sala.getContador() < id || id <= 0) {
			return -1;
		}

		for (Sala s : listaSalas) {
			if (s.getIdentificador() == id) {
				numSesiones = s.getSesiones().size();
				check = listaSalas.remove(s);
				if (check == false) {
					return -1;
				}
				return numSesiones;
			}
		}

		return -1;
	}
	
	
	/**
	 * Metodo que elimina una entrada de la lista de entradas del cine
	 * @param id Identificador de la entrada que se desea eliminar
	 * @return Sesion de la entrada que has eliminado
	 */
	public Sesion removeEntrada(int id) {
		Sesion ses;
		Boolean check;

		if (Entrada.getContador() < id || id <= 0) {
			return null;
		}

		for (Entrada entr : listaEntradas) {
			if (id == entr.getIdentificador()) { // Busca la entrada a borrar
				ses = entr.getSesion();
				check = listaEntradas.remove(entr);
				if (check == false) {
					return null;
				}
				return ses;

			}
		}
		return null;

	}

	@Override
	/**
	 * Metodo toString, necesario para imprimir por pantalla la informacion del cine de forma legible
	 * @return la cadena con la informacion sobre el cine
	 */
	public String toString() {

		String cadena = "" + nombre + ". Dirección: " + direccion + "\n\n";

		cadena += "Películas: \n";

		for (Pelicula p : this.listaPeliculas) {
			cadena += p + "\n";
		}

		cadena += "\nSalas: \n";

		for (Sala s : this.listaSalas) {
			cadena += s + "\n";
		}

		cadena += "\nEntradas: \n";

		for (Entrada e : this.listaEntradas) {
			cadena += e + "\n";
		}

		return cadena;
	}

}
