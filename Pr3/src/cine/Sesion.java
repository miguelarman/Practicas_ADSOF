package cine;
import java.util.Date;

public class Sesion {
	
	private Date fecha;
	private Pelicula pelicula;
	private int butacasDisponibles;
	private Sala sala;
	

	public Sesion(Date fecha, Pelicula pelicula, Sala sala) {
		this.fecha = fecha;
		this.pelicula = pelicula;
		this.butacasDisponibles = sala.getButacas();
		this.sala = sala;
	}
	
	
	public Boolean actualizarButacasVendidas() {
		
		return true;
	}


	public Date getFecha() {
		return fecha;
	}


	public Pelicula getPelicula() {
		return pelicula;
	}


	public int getButacasDisponibles() {
		return butacasDisponibles;
	}


	public Sala getSala() {
		return sala;
	}

	
	

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}


	public void setButacasDisponibles(int butacasDisponibles) {
		this.butacasDisponibles = butacasDisponibles;
	}


	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	
	
	
	
	
	public Date fin() {
		Date fechaAux = (Date)fecha.clone();
		
		fechaAux.setMinutes(fechaAux.getMinutes() + pelicula.getDuracion());
		
		return fechaAux;
	}

}
