package cine;



public class Entrada {
	private static int contador = 0;
	private int identificador;
	private Sesion sesion;
	private static Float precio = (float) 9.0;

	public Entrada(Sesion sesion) {

		if (sesion.getButacasDisponibles() == 0) {
			return;
		} else {
			contador++;
			setIdentificador(contador);
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

	public int getIdentificador() {
		return identificador;
	}
	
	public static int getContador() {
		return contador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

}
