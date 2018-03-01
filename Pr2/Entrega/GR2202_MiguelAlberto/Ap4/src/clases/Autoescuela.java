package Ap4.src.clases;

import java.util.*;

/**
* Esta clase almacena los datos de una Autoescuela en concreto. Esto incluye datos internos de la Autoescuela (nombre, direccion, etc.) y listas de profesores que imparten clases en ella
* 
* @author Miguel Arconada (miguel.arconada@estudiante.uam.es) y Alberto Gonzalez (alberto.gonzalezk@estudiante.uam.es)
*/
	
public class Autoescuela{

	
	private String codigoInterno;
	private String nombre;
	private String direccion;
	private String encargado;
	private List<Profesor> profesores;


	/**
	* Metodo constructor de la clase Autoescuela. Crea un objeto con los datos especificados en los parametros:
	* @param codigoInterno Codigo interno identificativo de cada autoescuela
	* @param nombre Nombre de la Autoescuela
	* @param direccion Direccion de la autoescuela
	* @param encargado Encargado de la autoescuela
	*/
	public Autoescuela(String codigoInterno, String nombre, String direccion, String encargado){
		this.codigoInterno = codigoInterno;
		this.direccion = direccion; 
		this.encargado = encargado;
		this.nombre = nombre;
		profesores = new ArrayList<Profesor>();
	}


	/**
	* Metodo que anade un objeto de la clase profesor a la lista de docentes de la escuela
	* @param dni, nombre, apellidos, telefono, numeroSS, antiguedad, sueldoBase, carnetImparte parametros necesarios para crear el profesor
	* @param anyo, mes, dia parametros necesarios para crear la fecha de inicio de docencia
	* @return valor booleano que representa si la funcion se ha llevado a cabo correctamente
	*/
	public Boolean anadirProfesor(String dni, String nombre, String apellidos, String telefono, String numeroSS, int antiguedad, float sueldoBase, List<String> carnetImparte, int anyo, int mes, int dia){
		
		for (Profesor paux : profesores) {
			if (paux.getDni() == dni) {
				Docencia d = new Docencia(anyo, mes, dia, paux, this);
				paux.anadirDocencia(d);
				
				return true;
			}
		}
		
		Profesor p = new Profesor(dni, nombre, apellidos, telefono, numeroSS, antiguedad, sueldoBase, carnetImparte);
		Docencia d = new Docencia(anyo, mes, dia, p, this);
		p.anadirDocencia(d);
		profesores.add(p);
		
		
		return true;
	}



	/**
	* Metodo que inicializa la fecha de final de docencia de un profesor
	* @param anyo Anyo de la fecha de finalizacion de la docencia
	* @param mes Mes de la fecha de finalizacion de la docencia
	* @param dia Dia de la fecha de finalizacion de la docencia
	* @param dni DNI del profesor que se desea modificar
	*/
	public Boolean finalizarDocente(int anyo, int mes, int dia, String dni){

		Boolean aux;

		for (Profesor p : profesores){
			if(p.getDni() == dni){
				aux = p.finalizarDocencia(anyo, mes, dia);
				if (aux == false){
					return false;
				}
				return true;
			}
		}
		return false;
	}


	/**
	* Metodo que devuelve una cadena de caracteres con las fechas de docencia de un profesor con cierto DNI en esta autoescuela
	* @param dni DNI del profesor del que se desean obtener los datos
	* @return cadena de caracteres con las fechas de docencia del profesor
	*/
	public String getFechaDocencia(String dni){

		List<Fecha> c1, c2;
		String s;

		for(Profesor p : profesores){
			if (p.getDni() == dni){
				c1 = p.getFechaInicio(this);
				c2 = p.getFechaFin(this);
				
				s = "";
				
				Integer long1 = c1.size();
				Integer long2 = c2.size();
				
				for (int i = 0; i < long2; i++) {
					
					if (i > 0) {
						s += ", ";
					}
					
					s += "desde el " + c1.get(i) + " hasta el " + c2.get(i);
					
				}
				
				if (long1 > long2) {
					s += ", desde el " + c1.get(long1 - 1) + " hasta la actualidad";
				}
				
				return s; 
			}
		}
		
		return null;
	}
	
	
	/**
	* Metodo getter del nombre de la autoescuela
	* @return nombre de la autoescuela
	*/
	public String getNombreAutoescuela(){
		return this.nombre;
	}
	
	
	/**
	* Metodo que devuelve el nombre de un docente de la autoescuela por su dni
	* @return nombre completo del docente
	*/
	public String getNombrePorDni (String dni) {
		
		for (Profesor p : profesores) {
			if (p.getDni() == dni) {
				return p.getNombreCompleto();
			}
		}
		
		return null;
	}
}