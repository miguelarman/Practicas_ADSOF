package terminales;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import funciones.Funcion;
import interfaces.INodo;

/**
 * Clase que implementa los nodos de tipo hoja, es decir, que no tienen descendientes
 * 
 * @author Miguel Arconada (miguel.arconada@estudiante.uam.es) Alberto Gonzalez (alberto.gonzalezk@estudiante.uam.es)
 */
public abstract class Terminal implements INodo {
	
	/**
	 * Simbolo con el que representar este tipo de terminales al imprimir un
	 * individuo
	 */
	private static String raiz;
	
	/**
	 * Padre del nodo
	 */
	private INodo padre;
	
	/**
	 * Constructor de la clase Terminal
	 * 
	 * @param raiz Simbolo del terminal
	 */
	public Terminal(String raiz) {
		Terminal.raiz = raiz;
	}
	

	@Override
	public String getRaiz() {
		return Terminal.raiz;
	}

	@Override
	public List<INodo> getDescendientes() {
		return new ArrayList<INodo>();
	}

	@Override
	public void incluirDescendiente(INodo nodo) {
		return;
	}

	@Override
	public abstract double calcular();

	@Override
	public abstract INodo copy();
	
	@Override
	public int etiquetaNodoRecursivo(HashMap<Integer, INodo> etiquetas, int i) {
		etiquetas.put(i, this);
		i += 1;
		return i;
	}
	@Override
	public void crearNodoAleatorioRecursivo(int profundidad, List<Terminal> terminales, List<Funcion> funciones) {
		return;
	}
	@Override
	public abstract String toString();
	
	@Override
	public INodo getPadre() {
		return this.padre;
	}
	
	@Override
	public void setPadre(INodo nodo) {
		this.padre = nodo;
	}

	@Override
	public int contarHijos() {
		return 0;
	}
	
	@Override
	public boolean equals(Object o) {
		return false;
	}
	
	@Override
	public void actualizarPadres() {
		for (INodo hijo : this.getDescendientes()) {
			hijo.setPadre(this);
			hijo.actualizarPadres();
		}
	}

}
