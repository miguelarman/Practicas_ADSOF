import java.util.*;

public class Autoescuela{
	private String codigoInterno;
	private String nombre;
	private String direccion;
	private String encargado;
	private List<Profesor> profesores;

	public Autoescuela(String codigoInterno, String nombre, String direccion, String encargado){
		this.codigoInterno = codigoInterno;
		this.direccion = direccion; 
		this.encargado = encargado;
		this.nombre = nombre;
		profesores = new ArrayList<Profesor>();
	}

	public void anadirProfesor(String dni, String nombre, String apellidos, String telefono, String numeroSS, int antiguedad, float sueldoBase, List<String> carnetImparte, int anyo, int mes, int dia){
		Profesor p = new Profesor(dni, nombre, apellidos, telefono, numeroSS, antiguedad, sueldoBase, carnetImparte);
		Docencia d = new Docencia(new Fecha(anyo, mes, dia), p, this);
		p.anadirDocencia(d); 
		profesores.add(p);
		return;
	}

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

	public String getFechaDocencia(String dni){

		Fecha c1, c2;
		String s;

		for(Profesor p : profesores){
			if (p.getDni() == dni){
				c1 = p.getFechaInicio(this);
				c2 = p.getFechaFin(this);
				s = "desde el " + c1 + " "+ "hasta el " + c2 + ".";
				return s; 
			}
		}
		return null;
	} 
	public String getNombreAutoescuela(){
		return this.nombre;
	}



	
}