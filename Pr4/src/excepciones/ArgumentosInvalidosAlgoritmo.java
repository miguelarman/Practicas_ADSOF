package excepciones;

/**
 * Excepcion lanzada cuando se pasan argumentos invalidos al constructor de Algoritmo
 * 
 * @author Miguel Arconada (miguel.arconada@estudiante.uam.es) Alberto Gonzalez (alberto.gonzalezk@estudiante.uam.es)
 */
public class ArgumentosInvalidosAlgoritmo extends Exception {

	/**
	 * Clave generada por Java
	 */
	private static final long serialVersionUID = -4709017970101669491L;
	
	/**
	 * Descripcion del problema encontrado con los argumentos
	 */
	private String descripcion;

	/**
	 * Constructor de la excepcion
	 * 
	 * @param string Descripcion del problema encontrado
	 */
	public ArgumentosInvalidosAlgoritmo(String string) {
		this.descripcion = string;
	}
	
	@Override
	public String toString() {
		return this.descripcion;
	}
}
