package cine;

import java.util.Calendar;


/**
 * Clase Sesion. Almacena los datos identificativos de una sesion (fehca, pelicula), así como un contador de las butacas disponibles.
 * Hace llamadas a metodos de las clases Pelicula y Sala, puesto que tiene atributos de dichas clases
 * @author Miguel Arconada (miguel.arconada@estudiante.uam.es) Alberto Gonzalez (alberto.gonzalezk@estudiante.uam.es)
 *
 */
public class Sesion {
	/**
	 * Fecha y hora de la sesion
	 */
	private Calendar fecha;
	/**
	 * Pelicula proyectada en la sesion
	 */
	private Pelicula pelicula;
	/**
	 * Cantidad de butacas disponibles para la sesion en cuestion
	 */
	private Integer butacasDisponibles;
	/**
	 * Sala asociada a la sesion
	 */
	private Sala sala;

	/**
	 * Constructor de la clase Sesion
	 * @param anyo Anno de inicio de la proyeccion
	 * @param mes Mes de inicio de la proyeccion
	 * @param dia Dia de inicio de la proyeccion
	 * @param hora Hora de inicio de la proyeccion
	 * @param minuto Minuto de inicio de la proyeccion
	 * @param pelicula Pelicula a proyectar
	 * @param sala Sala en la que se desarrolla la sesion
	 */
	public Sesion(Integer anyo, Integer mes, Integer dia, Integer hora, Integer minuto, Pelicula pelicula, Sala sala) {
		this.fecha = Calendar.getInstance();
		this.fecha.set(Calendar.YEAR, anyo);
		switch(mes) {
			case 1: this.fecha.set(Calendar.MONTH, Calendar.JANUARY); 
					break;
			case 2: this.fecha.set(Calendar.MONTH, Calendar.FEBRUARY);
					break;
			case 3: this.fecha.set(Calendar.MONTH, Calendar.MARCH);
					break;
			case 4: this.fecha.set(Calendar.MONTH, Calendar.APRIL);
					break;
			case 5: this.fecha.set(Calendar.MONTH, Calendar.MAY);
					break;
			case 6: this.fecha.set(Calendar.MONTH, Calendar.JUNE);
					break;
			case 7: this.fecha.set(Calendar.MONTH, Calendar.JULY);
					break;
			case 8: this.fecha.set(Calendar.MONTH, Calendar.AUGUST);
					break;
			case 9: this.fecha.set(Calendar.MONTH, Calendar.SEPTEMBER);
					break;
			case 10: this.fecha.set(Calendar.MONTH, Calendar.OCTOBER);
					break;
			case 11: this.fecha.set(Calendar.MONTH, Calendar.NOVEMBER);
					break;
			case 12: this.fecha.set(Calendar.MONTH, Calendar.DECEMBER);
					break;
			default: System.out.println("Mes introducido incorrecto");
					return;			
		}
		
		this.fecha.set(Calendar.DAY_OF_MONTH, dia);
		this.fecha.set(Calendar.HOUR_OF_DAY, hora);	
		this.fecha.set(Calendar.MINUTE, minuto);
		this.pelicula = pelicula;
		this.butacasDisponibles = sala.getButacas();
		this.sala = sala;
		if(sala.anadirSesion(this) == false) {
			System.out.println("No es posible crear una sesion en la sala indicada en el tiempo indicado.\n");
		};
	}
	
	
	// Getters
	
	/**
	 * Metodo getter de la fecha
	 * @return Fecha de la sesion
	 */
	public Calendar getFecha() {
		return fecha;
	}
	
	/**
	 * Metodo getter de la pelicula
	 * @return Pelicula de la sesion
	 */
	public Pelicula getPelicula() {
		return pelicula;
	}
	
	/**
	 * Metodo getter de las butacas disponibles
	 * @return Butacas disponibles para la sesion
	 */
	public int getButacasDisponibles() {
		return butacasDisponibles;
	}
	
	/**
	 * Metodo getter de la sala
	 * @return Sala de la sesion
	 */
	public Sala getSala() {
		return sala;
	}
	
	
	// Setters
	
	/**
	 * Metodo setter de la fecha
	 * @param fecha Nueva fecha de la sesion
	 */
	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	
	/**
	 * Metodo setter de la pelicula
	 * @param pelicula Nueva Pelicula de la sesion
	 */
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	
	/**
	 * Metodo setter de las butacas disponibles
	 * @param butacasDisponibles Nueva cantidad de butacas disponibles de la sesion
	 */
	public void setButacasDisponibles(int butacasDisponibles) {
		this.butacasDisponibles = butacasDisponibles;
	}
	
	/**
	 * Metodo setter de la sala
	 * @param sala Nueva sala de la sesion
	 */
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	
	
	/**
	 * Metodo que calcula el momento de finalizacion de la sesion
	 * Utilizado para que no pueda haber en una misma sala dos sesiones solapandose, es decir,
	 * que una empiece antes de que termine la otra
	 * @return Fecha y hora de finalizacion de la sesion
	 */
	public Calendar finalSesion() {
		Calendar fechaAux = (Calendar) fecha.clone();

		fechaAux.add(Calendar.MINUTE, pelicula.getDuracion());

		return fechaAux;
	}
	
	/**
	 * Metodo que actualiza el numero de butacas disponibles para la sala.
	 * Se comprueba si se puede vender una entrada, o si ya estan agotadas
	 * @return Valor booleano <ul>
	 * <li>True si se ha podido decrementar el numero de butacas disponibles</li>
	 * <li>False en cualquier otro caso</li></ul>
	 */
	public Boolean actualizarButacasVendidas() {

		if (butacasDisponibles < 1) {
			return false;
		} else {
			butacasDisponibles--;
			return true;
		}
	}
	
	
	@Override
	/**
	 * Metodo toString de la clase Sesion. Necesario para imprimir por pantalla los datos de una sesion en formato legible
	 * @return Cadena imprimible con los datos de la sesion
	 */
	public String toString() {
		int mes = 0;
		switch(fecha.get(Calendar.MONTH)) {
		case Calendar.JANUARY:
			mes = 1;
			break;
		case Calendar.FEBRUARY:
			mes = 2;
			break;
		case Calendar.MARCH:
			mes = 3;
			break;
		case Calendar.APRIL:
			mes = 4;
			break;
		case Calendar.MAY:
			mes = 5;
			break;
		case Calendar.JUNE:
			mes = 6;
			break;
		case Calendar.JULY:
			mes = 7;
			break;
		case Calendar.AUGUST:
			mes = 8;
			break;
		case Calendar.SEPTEMBER:
			mes = 9;
			break;
		case Calendar.OCTOBER:
			mes = 10;
			break;
		case Calendar.NOVEMBER:
			mes = 11;
			break;
		case Calendar.DECEMBER:
			mes = 12;
			break;				
		}
		
		return "Fecha: "+ fecha.get(Calendar.YEAR) + "/" + mes + "/" + fecha.get(Calendar.DAY_OF_MONTH) + "\n" + "Hora: " + fecha.get(Calendar.HOUR_OF_DAY) + ":" + fecha.get(Calendar.MINUTE) + "\nPelicula: " + pelicula.getTitulo() + "\nSala: " + sala.getIdentificador() + "\n" + "Butacas disponibles: " + butacasDisponibles + "\n";
	}

}
