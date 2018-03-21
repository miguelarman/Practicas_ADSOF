package cine;

public class Entrada {
	private Sesion sesion;
	private static Float precio = (float) 9.0;

	public Entrada(Sesion sesion) {

		if (sesion.getButacasDisponibles() == 0) {
			return;
		} else {

			this.sesion = sesion;
			
			this.sesion.actualizarButacasVendidas();

		}
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
	
	/**
	 * @param precio
	 */
	public static void setPrecio(Float precio) {
		Entrada.precio = precio;
	}

}
