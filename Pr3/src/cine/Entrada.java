package cine;

public class Entrada {
	private Sesion sesion;
	private Float precio;

	public Entrada(Sesion sesion, Float precio) {

		if (sesion.getButacasDisponibles() == 0) {
			return;
		} else {

			this.sesion = sesion;
			this.precio = precio;
			
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

}
