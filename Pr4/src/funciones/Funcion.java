package funciones;

import java.util.ArrayList;
import java.util.List;

import interfaces.INodo;

public abstract class Funcion implements INodo, Cloneable {
	
	private String raiz;
	private List<INodo> descendientes;
	
	public Funcion(String raiz) {
		this.raiz = raiz;
		this.descendientes = new ArrayList<INodo>();
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

//		for (INodo n : this.descendientes) {
//			if (n.equals(nodo)) {
//				return;
//			}
//		}
		
		this.descendientes.add(nodo);
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
