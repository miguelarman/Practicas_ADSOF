/**
 * 
 */
package cine;
import java.util.*;

/**
 * @author eps
 *
 */
public class Cine {
	private String nombre;
	private String direccion;
	private List<Pelicula> listaPeliculas;
	private List<Sala> listaSalas;
	private List<Entrada> listaEntradas;
	
	public Cine(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.listaPeliculas = new ArrayList<Pelicula>();
		this.listaEntradas = new ArrayList<Entrada>();	
		this.listaSalas = new ArrayList<Sala>();
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @return the listaPeliculas
	 */
	public List<Pelicula> getListaPeliculas() {
		return listaPeliculas;
	}

	/**
	 * @return the listaEntradas
	 */
	public List<Entrada> getListaEntradas() {
		return listaEntradas;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @param listaPeliculas the listaPeliculas to set
	 */
	public void setListaPeliculas(List<Pelicula> listaPeliculas) {
		this.listaPeliculas = listaPeliculas;
	}

	/**
	 * @param listaEntradas the listaEntradas to set
	 */
	public void setListaEntradas(List<Entrada> listaEntradas) {
		this.listaEntradas = listaEntradas;
	}
	
	public Boolean anadirPelicula(Pelicula peli) {
		this.listaPeliculas.add(peli);
		return true;
		
	}
	public Boolean anadirSala(Sala sala) {
		this.listaSalas.add(sala);
		return true;
		
	}
	public Boolean anadirSesionToSala(Sesion sesion, int sala) {
		for(Sala s: this.listaSalas) {
			if (s.getIdentificador() == sala) {
				s.anadirSesion(sesion);
				sesion.setSala(s);
				return true;
			}
		}
		return false;
	}
	public Boolean anadirPeliculaToSesion(String peli, Sesion s) {
		
		return true;
		
	}
	
	

}
