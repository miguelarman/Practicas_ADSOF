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
					break;			
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

	public Calendar finalSesion() {
		Calendar fechaAux = (Calendar) fecha.clone();

		fechaAux.add(Calendar.MINUTE, pelicula.getDuracion());

		return fechaAux;
	}
	
	public Boolean actualizarButacasVendidas() {

		if (butacasDisponibles < 1) {
			return false;
		} else {
			butacasDisponibles--;
			return true;
		}
	}
	
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
