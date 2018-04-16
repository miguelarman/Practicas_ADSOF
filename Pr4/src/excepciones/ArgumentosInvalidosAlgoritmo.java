package excepciones;

public class ArgumentosInvalidosAlgoritmo extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4709017970101669491L;
	private String descripcion;

	public ArgumentosInvalidosAlgoritmo(String string) {
		this.descripcion = string;
	}
	
	@Override
	public String toString() {
		return this.descripcion;
	}
}
