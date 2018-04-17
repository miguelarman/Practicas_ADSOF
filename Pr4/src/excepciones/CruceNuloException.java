package excepciones;

import java.util.List;

import interfaces.IIndividuo;

/**
 * Excepcion lanzada cuando al intentar cruzar dos individuos se escogen como
 * nodos de cruce la raiz de ambos individuos
 * 
 * @author Miguel Arconada (miguel.arconada@estudiante.uam.es) Alberto Gonzalez (alberto.gonzalezk@estudiante.uam.es)
 */
public class CruceNuloException extends Exception {

	/**
	 * Clave generada por Java
	 */
	private static final long serialVersionUID = 1342561630156543227L;
	
	/**
	 * Individuos que han causado el problema
	 */
	private List<IIndividuo> lista;

	
	/**
	 * Constructor de la excepcion
	 * 
	 * @param lista Nodos que causan el problema
	 */
	public CruceNuloException(List<IIndividuo> lista) {
		this.lista = lista;
	}
	
	/**
	 * Metodo getter para el campo lista
	 * 
	 * @return Nodos que han causado el problema
	 */
	public List<IIndividuo> getLista() {
		return this.lista;
	}
}
