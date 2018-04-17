package excepciones;

/**
 * Excepcion lanzada cuando se pasa un simbolo de funcion invalido
 * 
 * @author Miguel Arconada (miguel.arconada@estudiante.uam.es) Alberto Gonzalez (alberto.gonzalezk@estudiante.uam.es)
 */
public class SimboloFuncionInvalido extends Exception {

	/**
	 * Clave generada por Java
	 */
	private static final long serialVersionUID = -3376478932977524049L;
	
	/**
	 * Simbolo que ha causado la excepcion
	 */
	private String simbolo;
	
	/**
	 * COnstructor de la excepcion
	 * 
	 * @param string Simbolo causante del problema
	 */
	public SimboloFuncionInvalido(String string) {
		this.simbolo = string;
	}
	
	@Override
	public String toString() {
		return "El simbolo " + this.simbolo + " no representa ninguna funcion definida";
	}
}
