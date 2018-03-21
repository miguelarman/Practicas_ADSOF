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
	
	public int removePeliculaCartelera(String titulo) {
		
		int numSesiones = 0;
		Boolean check;
		
		for(Pelicula p: listaPeliculas) {
			if(titulo == p.getTitulo()) {
				for(Sala s: listaSalas)	{
					for(Sesion ses: s.getSesiones()) {
						if(ses.getPelicula() == p) {
							numSesiones++;
							check = s.getSesiones().remove(ses);
							if(check == false) {
								return -1;
							}
						}
					}
				}
				check = listaPeliculas.remove(p);
				if(check == false) {
					return -1;
				}
				return numSesiones;
			}
		}
		return -1;
	}
	
	public int removeSala(int id) {
		int numSesiones = 0;
		Boolean check;
		
		if(Sala.getContador() < id || id <= 0) {
			return -1;
		}
		
		for(Sala s: listaSalas) {
			if(s.getIdentificador() == id) {
				for(Sesion ses: s.getSesiones()) {
					check = s.getSesiones().remove(ses);
					if(check == false) {
						return -1;
					}
					numSesiones++;				
				}
				check = listaSalas.remove(s);
				if(check == false) {
					return -1;
				}
				return numSesiones;
			}
		}
		
		return -1;
	}
	
	public Sesion removeEntrada(int id) {
		Sesion ses;
		Boolean check;
		
		if(Entrada.getContador() < id || id <= 0) {
			return null;
		}
		
		for(Entrada entr: listaEntradas) {
			if(id == entr.getIdentificador()) {
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
	public String toString() {
		
		String cadena = "" + nombre + ". Direcci�n: " + direccion + "\n\n";
		
		cadena += "\tPel�culas: \n";
		
		for (Pelicula p : this.listaPeliculas) {
			cadena += p + "\n";
		}
		
		
		cadena += "\n\tSalas: \n";
		
		for (Sala s : this.listaSalas) {
			cadena += s + "\n";
		}
		
		
		cadena += "\n\tEntradas: \n";
		
		for (Entrada e : this.listaEntradas) {
			cadena += e + "\n";
		}
		
		
		return cadena;
	}
	
}
