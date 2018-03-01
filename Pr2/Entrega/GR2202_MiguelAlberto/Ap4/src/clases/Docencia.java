package Ap4.src.clases;

import java.util.*;



/**
* Esta clase almacena los datos de un periodo de docencia de un Profesor en una Autoescuela en concreto
* Pueden crearse mas de un periodo de docencia con un mismo profesor o autoescuela
* @author Miguel Arconada (miguel.arconada@estudiante.uam.es) y Alberto Gonzalez (alberto.gonzalezk@estudiante.uam.es)
*/



public class Docencia {

	private Fecha fechaInicio;
	private Fecha fechaFin;
	private Profesor docente;
	private Autoescuela autoescuela;



	/**
	* Metodo constructor de la clase. Devuelve un objeto de la clase Docencia que contiene lo pasado como argumentos:
	* @args anyo Anyo de la fecha de inicio del periodo de docencia
	* @args mes Mes de la fecha de inicio del periodo de docencia
	* @args dia Dia de la fecha de inicio del periodo de docencia
	* @args docente Profesor del que se esta creando el periodo de docencia
	* @args autoescuela Autoescuela en la que va a trabajar el profesor
	*/
	public Docencia(int anyo, int mes, int dia, Profesor docente, Autoescuela autoescuela) { 
		this.fechaInicio = new Fecha(anyo, mes, dia);
		this.docente = docente;
		this.autoescuela = autoescuela;
		fechaFin = null;
	}


	/**
	* Metodo que termina un periodo de docencia, estableciendo un valor para el atributo fechaFIn, que hasta el momento era null
	* @args anyo Anyo de la fecha de finalizacion del periodo de docencia
	* @args mes Mes de la fecha de finalizacion del periodo de docencia
	* @args dia Dia de la fecha de finalizacion del periodo de docencia
	* @return un valor booleano que representa si la funcion se ha llevado a cabo
	*/
	public Boolean finDocencia(int anyo, int mes, int dia){
		
		Fecha fechaFin = new Fecha(anyo, mes, dia);

		if(this.fechaFin != null || fechaFin.isFechaValida() == false){
			return false;
		}

		this.fechaFin = fechaFin;
		return true;
	}


	/**
	* Metodo getter de la Autoescuela del periodo de docencia
	* @return el atributo Autoescuela del objeto de Docencia
	*/
	public Autoescuela getAutoescuelaDocencia(){
		return this.autoescuela;
	}


	/**
	* Metodo getter de la fecha de inicio del periodo de docencia
	* @return el atributo fechaInicio del objeto de Docencia
	*/
	public Fecha getFechaInicioDocencia(){
		return fechaInicio;
	}


	/**
	* Metodo getter de la fecha de fin del periodo de docencia
	* @return el atributo fechaFin del objeto de Docencia
	*/
	public Fecha getFechaFinDocencia(){
		return fechaFin;
	}
}