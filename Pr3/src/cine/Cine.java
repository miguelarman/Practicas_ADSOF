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




	
	public Boolean anadirPelicula(Pelicula peli) {
		this.listaPeliculas.add(peli);
		return true;
	}
	
	public Boolean anadirSala(Sala sala) {
		this.listaSalas.add(sala);
		return true;
	}
	
	public Boolean anadirEntrada(Entrada e) {
		this.listaEntradas.add(e);
		return true;
	}
	
	public Boolean anadirSesionASala(Sesion sesion, int sala) {
		for(Sala s: this.listaSalas) {
			if (s.getIdentificador() == sala) {
				s.anadirSesion(sesion);
				sesion.setSala(s);
				return true;
			}
		}
		return false;
	}
	
	
	public Boolean anadirPeliculaASesion(String peli, Sesion s) {
		
		for (Pelicula p : listaPeliculas) {
			if (p.getTitulo() == peli) {
				s.setPelicula(p);
				
				return true;
			}
		}
		
		return false;
	}
	
	
	public Entrada venderEntrada(Sesion s) {
		
		Calendar fecha = s.getFecha();
		Entrada entrada;
		
		if (EntradaDiaEspectador.isFechaEspectador(fecha)) {
			entrada = new EntradaDiaEspectador(s);
		} else {
			entrada = new Entrada(s);
		}
		
		this.anadirEntrada(entrada);
		
		return entrada;
	}
	
	public Float informacionRecaudacion() {
		
		Float total = (float) 0;
		
		for (Entrada e : this.listaEntradas) {
			total += e.getPrecio();
		}
		
		return total;
	}
	
	public String informacionCartelera() {
		
		String cadena = "";
		
		for (Pelicula p : this.listaPeliculas) {
			cadena += "\n" + p;
		}
		return cadena;
	}
	
	public String informacionSesiones() {
		
		List<Sesion> sesiones = new ArrayList<Sesion>();
		String cadena = "";
		
		for (Sala s : listaSalas ) {
			sesiones.addAll(s.getSesiones());
		}
		
		for (Sesion se : sesiones) {
			cadena += "\n" + se;
		}
		
		return cadena;
		
	}
	
}
