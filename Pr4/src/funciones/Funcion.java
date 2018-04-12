package funciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import interfaces.INodo;

public abstract class Funcion implements INodo, Cloneable {
	
	private String raiz;
	private List<INodo> descendientes;
	protected Integer maximosDescendientes;
	
	public Funcion(String raiz, Integer maximosDescendientes) {
		this.raiz = raiz;
		this.descendientes = new ArrayList<INodo>();
		this.maximosDescendientes = maximosDescendientes;
	}

	@Override
	public String getRaiz() {
		return this.raiz;
	}

	@Override
	public List<INodo> getDescendientes() {
		return this.descendientes;
	}

	@Override
	public void incluirDescendiente(INodo nodo) {
		if (this.descendientes.size() < this.maximosDescendientes) {
			this.descendientes.add(nodo);
		}
	}

	@Override
	public abstract double calcular();

	@Override
	public abstract INodo copy();
	
	@Override
	public int etiquetaNodoRecursivo(HashMap<Integer, INodo> etiquetas, int i) {
		etiquetas.put(i, this);
		i++;
		
		for (INodo nodo : this.getDescendientes()) {
			i = nodo.etiquetaNodoRecursivo(etiquetas, i);
		}
		
		return i;
	}
	
	public int contarHijos() {
		int numHijos = 0;
		for(INodo n : descendientes) {
			numHijos += n.contarHijos();
		}
		return numHijos;
	}
	
	@Override
	public String toString() {
		String string = "";
		
		string += "( " + this.getRaiz();
		
		for (INodo n : this.getDescendientes()) {
			string += " " + n;
		}
		
		string += " )";
		
		return string;
	}

}
