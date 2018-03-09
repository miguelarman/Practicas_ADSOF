package cine;
import java.util.Calendar;

public class Sesion {
	
	private Calendar fecha;
	private Pelicula pelicula;
	private Integer butacasDisponibles;
	private Sala sala;
	

	public Sesion(Integer anyo, Integer mes, Integer dia, Integer hora, Integer minuto, Pelicula pelicula, Sala sala) {
		this.fecha = Calendar.getInstance();
		this.fecha.set(Calendar.YEAR, anyo);
		this.fecha.set(Calendar.MONTH, mes);
		this.fecha.set(Calendar.DAY_OF_MONTH, dia);
		this.fecha.set(Calendar.HOUR, hora);
		this.fecha.set(Calendar.MINUTE, minuto);
		this.pelicula = pelicula;
		this.butacasDisponibles = sala.getButacas();
		this.sala = sala;
	}
	
	
	public Boolean actualizarButacasVendidas() {
		
		return true;
	}


	public Calendar getFecha() {
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

	
	

	public void setFecha(Calendar fecha) {
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
	
	
	
	
	
	
	
	public Calendar fin() {
		Calendar fechaAux = (Calendar)fecha.clone();
		
		fechaAux.add(Calendar.MINUTE, pelicula.getDuracion());
		
		return fechaAux;
	}

}
