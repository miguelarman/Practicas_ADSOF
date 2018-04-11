package funciones;

import java.util.ArrayList;
import java.util.List;

import interfaces.INodo;

public abstract class Funcion implements INodo, Cloneable {
	
	private String raiz;
	private List<INodo> descendientes;
	private Integer maximosDescendientes;
	
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
