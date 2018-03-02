package cine;

import java.util.*;

public class Sala {
	
	private static int identificador = 0;
	private int butacas;
	private List<Sesion> sesiones;
	
	
	public Sala(int butacas) {
		this.butacas = butacas;
		identificador++;
		this.sesiones = new ArrayList<Sesion>();
	}


	public static int getIdentificador() {
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
			if (sesionAux.fin().after(sesion.getFecha()) || sesionAux.equals(sesion)) {
				return false;
			}
		}
		
		sesiones.add(sesion);
		
		return true;
	}
	
	

}
