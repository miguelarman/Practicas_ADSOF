public class Persona {

	private String dni;
	private String nombre;
	private String apellidos;
	private String telefono;




	public Persona(String dni, String nombre, String apellidos, String telefono) { 
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
	}
	
	public String getDni(){
		return this.dni;
	}

	
	
	
	public String getNombreCompleto() {

		return "" + nombre + " " + apellidos;
	}
}