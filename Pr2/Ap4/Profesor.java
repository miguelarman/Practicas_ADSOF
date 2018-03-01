import java.util.*;


public class Profesor extends Persona{

	private String numeroSS;
	private int antiguedad;
	private float sueldoBase;
	private List<String> carnetImparte;
	private List<Docencia> datosDocencia;




	public Profesor(String dni, String nombre, String apellidos, String telefono, String numeroSS, int antiguedad, float sueldoBase, List<String> carnetImparte) { 
		super.Persona(dni, nombre, apellidos, telefono);
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
	
	public List<Fecha> getFechaFin(Autoescuela a){

		List<Fecha> fechas = new ArrayList<Fecha>();

		for(Docencia d: datosDocencia){
			if(d.getAutoescuelaDocencia() == a){
				fechaAux = d.getFechaFinDocencia();
				fechas.add(fechaAux);
			}

		}
		
		return fechas;
	}
}