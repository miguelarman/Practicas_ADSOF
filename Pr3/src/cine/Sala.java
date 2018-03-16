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


	public int getIdentificador() {
		return identificador;
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
