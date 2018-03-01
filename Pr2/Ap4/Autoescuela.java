import java.util.*;

/**
* 
*****/
	
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

	public Boolean anadirProfesor(String dni, String nombre, String apellidos, String telefono, String numeroSS, int antiguedad, float sueldoBase, List<String> carnetImparte, int anyo, int mes, int dia){
		Profesor p = new Profesor(dni, nombre, apellidos, telefono, numeroSS, antiguedad, sueldoBase, carnetImparte);
		Docencia d = new Docencia(anyo, mes, dia, p, this);

		if (!profesores.contains(p)){
			
			p.anadirDocencia(d);
			profesores.add(p);
			
			return true;
			
		} else {
			
			for (Profesor paux : profesores) {
				if (paux == p) {
					paux.anadirDocencia(d);
					
					return true;
				}
			}
		}
		
		return false;
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
				
				if (c1 > c2) {
					s += ", desde el " + c1.get(long1 - 1) + " hasta la actualidad";
				}
				
				return s; 
			}
		}
		
		return null;
	}
	
	
	public String getNombreAutoescuela(){
		return this.nombre;
	}
	
	public String getNombrePorDni (String dni) {
		
		for (Profesor p : profesores) {
			if (p.getDni() == dni) {
				return p.getNombreCompleto;
			}
		}
	}
}