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





	public Alumno(String dni, String nombre, String apellidos, int anyo, int mes, int dia, String tipoCarnetMatriculado) { 
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.tipoCarnetMatriculado = tipoCarnetMatriculado;
		this.fechaMatriculacion = new Fecha(anyo, mes, dia);
	}


	public Fecha getFechaMatr() {
		return fechaMatriculacion;
	}

	public String toString() {
		String cadena;

		cadena = "Nombre: " + nombre + "\nApellido: " + apellidos + "\nDNI: " + dni + "\nFecha Matricula: " + fechaMatriculacion + "\nTipo carnet: " + tipoCarnetMatriculado;

		return cadena;
	}
}