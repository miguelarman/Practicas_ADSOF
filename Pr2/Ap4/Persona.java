/**
* Clase que almacena los datos privados de una persona. Se extiende en la clase Profesor
* 
* @author Miguel Arconada (miguel.arconada@estudiante.uam.es) y Alberto Gonzalez (alberto.gonzalezk@estudiante.uam.es)
*/


public class Persona {

	private String dni;
	private String nombre;
	private String apellidos;
	private String telefono;



	/**
	* Metodo constructor de la clase Persona. Devuelve un objeto inicializado a los valores de los argumentos
	* @param dni DNI de la persona
	* @param nombre Nombre de la persona
	* @param apellidos Apellidos de la persona
	* @param telefono Telefono de la persona
	*/
	public Persona(String dni, String nombre, String apellidos, String telefono) { 
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
	}
	
	
	/**
	* Metodo getter del DNI de la persona
	* @return dni de la persona
	*/
	public String getDni(){
		return this.dni;
	}

	
	
	/**
	* Metodo que devuelve el nombre completo de la persona
	* @return Nombre completo de la persona en una String en formato imprimible
	*/
	public String getNombreCompleto() {

		return "" + nombre + " " + apellidos;
	}
}