import java.util.*;


/**
* Clase que extiende Persona, y anade atributos y metodos especificos de los docentes
* 
* @author Miguel Arconada (miguel.arconada@estudiante.uam.es) y Alberto Gonzalez (alberto.gonzalezk@estudiante.uam.es)
*/

public class Profesor extends Persona{

	private String numeroSS;
	private int antiguedad;
	private float sueldoBase;
	private List<String> carnetImparte;
	private List<Docencia> datosDocencia;



	/**
	* Metodo costructor de la clase Profesor. Devuelve un objeto inicializado segun los parametros
	* @param dni, nombre, apellidos, telefono Parametros necesarios para inicializar la Persona
	* @param numeroSS Numero de la Seguridad Social del Profesor
	* @param antiguedad Antiguedad del profesor en su docencia
	* @param sueldoBase Sueldo base del docente
	* @param carnetImparte Lista de carnet que imparte el Profesor
	*/
	public Profesor(String dni, String nombre, String apellidos, String telefono, String numeroSS, int antiguedad, float sueldoBase, List<String> carnetImparte) { 
		super(dni, nombre, apellidos, telefono);
		this.numeroSS = numeroSS;
		this.antiguedad = antiguedad;
		this.sueldoBase = sueldoBase;
		this.carnetImparte = carnetImparte;
		datosDocencia = new ArrayList<Docencia>();
	}



	/**
	* Metodo que finaliza la docencia actual de un profesor
	* @param anyo Ano de fin de la docencia
	* @param mes Mes de fin de la docencia
	* @param dia Dia de fin de la docencia
	* @return Valor booleano que representa si la funcion se ha ejecutado satisfactoriamente
	*/
	public Boolean finalizarDocencia(int anyo, int mes, int dia){

		Boolean aux;

		aux = this.datosDocencia.get(this.datosDocencia.size() - 1).finDocencia(anyo, mes, dia);

		if(aux == false){
			return false;
		}
		return true;
	}
	
	
	
	/**
	* Metodo que anade una docencia a la lista de Docencias del profesor
	* @param d Docencia que se desea anadir
	*/
	public void anadirDocencia(Docencia d){
		this.datosDocencia.add(d);
		return;
	}

	
	
	/**
	* Metodo getter de las fechas de inicio de Docencia en una autoescuela
	* @param a Autoescuela de la que se desea obtener las fechas de inicio de docencias
	* @return Lista con todas las fechas de inicio de docencias en la autoescuela a
	*/
	public List<Fecha> getFechaInicio(Autoescuela a){
		
		List<Fecha> fechas = new ArrayList<Fecha>();
		
		for(Docencia d: datosDocencia){
			if(d.getAutoescuelaDocencia() == a){
				Fecha fechaAux = d.getFechaInicioDocencia();
				fechas.add(fechaAux); 
			}

		}
		
		return fechas;
	}
	
	
	
	/**
	* Metodo getter de las fechas de fin de Docencia en una autoescuela
	* @param a Autoescuela de la que se desea obtener las fechas de fin de docencias
	* @return Lista con todas las fechas de fin de docencias en la autoescuela a
	*/
	public List<Fecha> getFechaFin(Autoescuela a){

		List<Fecha> fechas = new ArrayList<Fecha>();
		Fecha fechaAux;

		for(Docencia d: datosDocencia){
			if(d.getAutoescuelaDocencia() == a){
				fechaAux = d.getFechaFinDocencia();
				fechas.add(fechaAux);
			}

		}
		
		return fechas;
	}
}