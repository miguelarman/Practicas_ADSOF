package terminales;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import interfaces.INodo;

public abstract class Terminal implements INodo {
	
	private static String raiz;
	
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
	public void incluirDescendiente(INodo nodo) {}

	@Override
	public abstract double calcular();

	@Override
	public abstract INodo copy();
	
	@Override
	public int etiquetaNodoRecursivo(HashMap<Integer, INodo> etiquetas, int i) {
		etiquetas.put(i, this);
		return i++;
	}
	
	@Override
	public abstract String toString();

}
