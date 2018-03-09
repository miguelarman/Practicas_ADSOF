package cine;

public class Entrada {
	private Sesion sesion;
	private Float precio;
	
	public Entrada(Sesion sesion, Float precio) {
		this.sesion = sesion;
		this.precio = precio;
	}

	/**
	 * @return the sesion
	 */
	public Sesion getSesion() {
		return sesion;
	}

	/**
	 * @return the precio
	 */
	public Float getPrecio() {
		return precio;
	}
	
	
	

}
