import java.util.*;
public class Docencia{

	private Fecha fechaInicio;
	private Fecha fechaFin;
	private Profesor docente;
	private Autoescuela autoescuela;




	public Docencia(Fecha fechaInicio, Profesor docente, Autoescuela autoescuela) { 
		this.fechaInicio = fechaInicio;
		this.docente = docente;
		this.autoescuela = autoescuela;
		fechaFin = null;
	}

	public Boolean finDocencia(int anyo, int mes, int dia){

		Fecha fechaFin = new Fecha(anyo, mes, dia);

		if(this.fechaFin != null || fechaFin.isFechaValida() == false){
			return false;
		}

		this.fechaFin = fechaFin;
		return true;
	}

	public Autoescuela getAutoescuelaDocencia(){
		return this.autoescuela;
	}
	public Fecha getFechaInicioDocencia(){
		return fechaInicio;
	}
	public Fecha getFechaFinDocencia(){
		return fechaFin;
	}
}