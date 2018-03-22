package cine;


/**
 * Clase que almacena los datos de una entrada. Hace llamadas a los metodos de la clase Sesion, puesto que tiene un atributo de esa clase
 * @author Miguel Arconada (miguel.arconada@estudiante.uam.es) Alberto Gonzalez (alberto.gonzalezk@estudiante.uam.es)
 *
 */
public class Entrada {
	/**
	 * Atributo de clase usado para contar cuantas entradas se han creado hasta el momento y poder generar un identificador unico para cada una
	 */
	private static int contador = 0;
	/**
	 * Identificador unico de la entrada
	 */
	private int identificador;
	/**
	 * Sesion para la cual se genera la entrada
	 */
	private Sesion sesion;
	/**
	 * Atributo de clase del precio, al ser constante para todas las entradas (sin tener en cuenta el descuento del dia del espectador)
	 */
	private static Float precio = (float) 9.0;
	
	/**
	 * Metodo constructor de la clase Entrada
	 * @param sesion Sesion para la cual es la entrada
	 */
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
	
	
	// Getters

	/**
	 * Metodo getter de la sesion
	 * @return Sesion de la entrada
	 */
	public Sesion getSesion() {
		return sesion;
	}

	/**
	 * Metodo getter del precio
	 * @return Precio de la entrada
	 */
	public Float getPrecio() {
		return precio;
	}
	
	/**
	 * Metodo getter del identificador
	 * @return Identificador de la entrada
	 */
	public int getIdentificador() {
		return identificador;
	}
	
	/**
	 * Metodo getter del contador
	 * @return Numero de entradas creadas
	 */
	public static int getContador() {
		return contador;
	}
	
	
	
	//Setters
	
	/**
	 * Metodo estatico setter del precio de las entradas
	 * @param precio Nuevo precio para las entradas
	 */
	public static void setPrecio(Float precio) {
		Entrada.precio = precio;
	}
	
	/**
	 * Metodo setter del identificador
	 * @param identificador Nuevo identificador de la entrada
	 */
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	
	
	//to String
	
	@Override
	/**
	 * Metodo toString de la clase Entrada. Necesario para imprimir por pantalla una entrada en formato legible
	 * @return Cadena imprimible con los datos de la entrada
	 */
	public String toString() {
		// TODO
		
		return "que no se nos olvide modificar esto";
	}

}
