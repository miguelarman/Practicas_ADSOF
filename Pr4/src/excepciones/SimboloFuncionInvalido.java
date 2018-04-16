package excepciones;

public class SimboloFuncionInvalido extends Exception {

	private static final long serialVersionUID = -3376478932977524049L;
	private String simbolo;
	
	public SimboloFuncionInvalido(String string) {
		this.simbolo = string;
	}
	
	@Override
	public String toString() {
		return "El simbolo " + this.simbolo + " no representa ninguna funcion definida";
	}
}
