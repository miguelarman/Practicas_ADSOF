package funciones;

import java.util.ArrayList;
import java.util.List;

import interfaces.INodo;

public class Funcion implements INodo, Cloneable {
	
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

		for (INodo n : this.descendientes) {
			if (n.equals(nodo)) {
				return;
			}
		}
		
		this.descendientes.add(nodo);
	}

	@Override
	public double calcular() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public INodo copy() {
		
		INodo nuevo = new Funcion(this.raiz);
		
		for (INodo n : this.descendientes) {
			INodo des = n.copy();
			n.incluirDescendiente(des);
		}
		
		return nuevo;
	}

}
