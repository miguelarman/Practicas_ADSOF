package excepciones;

import java.util.List;

import interfaces.IIndividuo;

public class CruceNuloException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1342561630156543227L;
	private List<IIndividuo> lista;

	public CruceNuloException(List<IIndividuo> lista) {
		this.lista = lista;
	}
	
	public List<IIndividuo> getLista() {
		return this.lista;
	}
}
