import java.util.*;



/**
* Esta clase almacena los datos de un periodo de docencia de un Profesor en una Autoescuela en concreto
* Pueden crearse más de un periodo de docencia con un mismo profesor o autoescuela
*/



public class Docencia{

	private Fecha fechaInicio;
	private Fecha fechaFin;
	private Profesor docente;
	private Autoescuela autoescuela;



	/**
	* Método constructor de la clase. Devuelve un objeto de la clase Docencia que contiene lo pasado como argumentos:
	* @args fechaInicio Fecha de inicio del periodo de docencia
	* @args docente Profesor del que se está creando el periodo de docencia
	* @args autoescuela Autoescuela en la que va a trabajar el profesor
	*/
	public Docencia(Fecha fechaInicio, Profesor docente, Autoescuela autoescuela) { 
		this.fechaInicio = fechaInicio;
		this.docente = docente;
		this.autoescuela = autoescuela;
		fechaFin = null;
	}


	/**
	* Método que termina un periodo de docencia, estableciendo un valor para el atributo fechaFIn, que hasta el momento era null
	* @args fechaFin Fecha de finalización del periodo de docencia
	* @return un valor booleano que representa si la función se ha llevado a cabo
	*/
	public Boolean finDocencia(Fecha fechaFin){

		if(this.fechaFin != null || fechaFin.isFechaValida() == false){
			return false;
		}

		this.fechaFin = fechaFin;
		return true;
	}


	/**
	* Método getter de la Autoescuela del periodo de docencia
	* @return el atributo Autoescuela del objeto de Docencia
	*/
	public Autoescuela getAutoescuelaDocencia(){
		return this.autoescuela;
	}


	/**
	* Método getter de la fecha de inicio del periodo de docencia
	* @return el atributo fechaInicio del objeto de Docencia
	*/
	public Fecha getFechaInicioDocencia(){
		return fechaInicio;
	}


	/**
	* Método getter de la fecha de fin del periodo de docencia
	* @return el atributo fechaFin del objeto de Docencia
	*/
	public Fecha getFechaFinDocencia(){
		return fechaFin;
	}
}