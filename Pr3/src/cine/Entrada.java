package cine;

public class Entrada {
	private static int contador = 0;
	private int identificador;
	private Sesion sesion;
	private Float precio;

	public Entrada(Sesion sesion, Float precio) {

		if (sesion.getButacasDisponibles() == 0) {
			return;
		} else {
			contador++;
			setIdentificador(contador);
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

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

}
