package cine;

import java.util.*;

public class Sala {
	
	private static int contador = 0;
	private int identificador;
	private int butacas;
	private List<Sesion> sesiones;
	
	
	public Sala(int butacas) {
		this.butacas = butacas;
		contador++;
		identificador = contador;
		this.sesiones = new ArrayList<Sesion>();
	}


	@Override
	public String toString() {
		String cadena = "Sala "+ identificador + ":\n" + "Número de butacas: "+ butacas + "\n" + "Sesiones:\n";
		int i = 1;
		for(Sesion s: sesiones) {
			cadena +="\n" + i + ":\n\n";
			cadena += s.toString();
			i++;
		}
		return cadena;
	}


	public int getIdentificador() {
		return identificador;
	}
	
	public static int getContador() {
		return contador;
	}


	public int getButacas() {
		return butacas;
	}
	
	public List<Sesion> getSesiones() {
		return sesiones;
	}

	
	

	public void setButacas(int butacas) {
		this.butacas = butacas;
	}
	
	
	
	
	public Boolean anadirSesion(Sesion sesion) {
		for (Sesion sesionAux : sesiones) {
			if (sesionAux.finalSesion().after(sesion.getFecha()) || sesionAux.equals(sesion)) {
				return false;
			}
		}
		
		sesiones.add(sesion);
		
		return true;
	}
	
	

}
