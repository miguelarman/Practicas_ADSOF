package terminales;

import java.util.ArrayList;
import java.util.List;

import interfaces.INodo;

public class Terminal implements INodo {
	
	private String raiz;
	
	public Terminal(String raiz) {
		this.raiz = raiz;
	}

	@Override
	public String getRaiz() {
		return this.raiz;
	}

	@Override
	public List<INodo> getDescendientes() {
		return new ArrayList<INodo>();
	}

	@Override
	public void incluirDescendiente(INodo nodo) {
		// TODO
	}

	@Override
	public double calcular() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public INodo copy() {
		INodo nuevo = new Terminal(this.raiz);
		
		return nuevo;
	}

}
