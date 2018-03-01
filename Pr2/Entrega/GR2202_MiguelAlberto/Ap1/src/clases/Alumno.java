package Ap1.src.clases;

/**
* Esta clase almacena los datos de un Alumno de una Autoescuela
* <p><b>Nota</b>: Para guardar una fecha en esta clase, al contructor hay que pasarle los atributos en el orden AAAA MM DD</p>
*
* @author Miguel Arconada (miguel.arconada@estudiante.uam.es) y Alberto Gonzalez (alberto.gonzalezk@estudiante.uam.es)
*
*/


public class Alumno {

	private String dni;
	private String nombre;
	private String apellidos;
	private long telefono;
	private String tipoCarnetTiene;
	private String tipoCarnetMatriculado;
	private float descuento;

	private Fecha fechaNacimiento;
	private Fecha fechaMatriculacion;
	private Fecha fechaApruebaTeoria;
	private Fecha fechaApruebaPracticas;




	/**
	* Constructor de la clase. Devuelve un nuevo objeto de la clase Alumno inicializada con los datos pasados por los parámetros.
	* @param dni Números y letra del DNI del alumno
	* @param nombre Nombre del alumno
	* @param apellidos Apellidos del alumno
	* @param anyo Año de la fecha de matriculación
	* @param mes Mes de la fecha de matriculación
	* @param dia Día de la fecha de matriculación
	* @param tipoCarnetMatriculado Tipo de carnet en el que se matricula el alumno
	* @return objeto de la clase Alumno con los valores anteriores
	*/
	public Alumno(String dni, String nombre, String apellidos, int anyo, int mes, int dia, String tipoCarnetMatriculado) { 
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.tipoCarnetMatriculado = tipoCarnetMatriculado;
		this.fechaMatriculacion = new Fecha(anyo, mes, dia);
	}

	/**
	* Getter de la fecha de matriculación del alumno
	* @return Objeto de la clase Fecha que contiene la fecha de matriculación del alumno
	*/
	public Fecha getFechaMatr() {
		return fechaMatriculacion;
	}

	/**
	* Función que transforma los datos del alumno a una cadena imprimible
	* @return Cadena con todos los datos del alumno
	*/
	public String toString() {
		String cadena;

		cadena = "Nombre: " + nombre + "\nApellido: " + apellidos + "\nDNI: " + dni + "\nFecha Matricula: " + fechaMatriculacion + "\nTipo carnet: " + tipoCarnetMatriculado;

		return cadena;
	}
}