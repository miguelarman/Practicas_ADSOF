package terminales;

import java.util.ArrayList;
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
	public double calcular() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public abstract INodo copy();

}
