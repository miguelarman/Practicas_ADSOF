import java.util.*;
public class Profesor {

	private String dni;
	private String nombre;
	private String apellidos;
	private String telefono;
	private String numeroSS;
	private int antiguedad;
	private float sueldoBase;
	private List<String> carnetImparte;

	private List<Docencia> datosDocencia;




	public Profesor(String dni, String nombre, String apellidos, String telefono, String numeroSS, int antiguedad, float sueldoBase, List<String> carnetImparte) { 
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.numeroSS = numeroSS;
		this.antiguedad = antiguedad;
		this.sueldoBase = sueldoBase;
		this.carnetImparte = carnetImparte;
		datosDocencia = new ArrayList<Docencia>();
	}

	public Boolean finalizarDocencia(int anyo, int mes, int dia){

		Boolean aux;

		aux = this.datosDocencia.get(this.datosDocencia.size() - 1).finDocencia(anyo, mes, dia);

		if(aux == false){
			return false;
		}
		return true;
	}

	public void anadirDocencia(Docencia d){
		this.datosDocencia.add(d);
		return;
	}

	public String getDni(){
		return this.dni;
	}

	public Fecha getFechaInicio(Autoescuela a){
		for(Docencia d: datosDocencia){
			if(d.getAutoescuelaDocencia() == a){
				return d.getFechaInicioDocencia();
			}

		}
		return null;
	}
	public Fecha getFechaFin(Autoescuela a){
		for(Docencia d: datosDocencia){
			if(d.getAutoescuelaDocencia() == a){
				return d.getFechaFinDocencia();
			}

		}
		return null;
	}
}