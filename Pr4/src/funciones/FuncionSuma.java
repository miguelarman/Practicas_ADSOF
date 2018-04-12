package funciones;

import interfaces.INodo;

public class FuncionSuma extends Funcion {

	public FuncionSuma(String raiz, int i) {
		super(raiz, i);
	}

	@Override
	public double calcular() {
		double resultado = 0.0;
		
		for (INodo nodo : this.getDescendientes()) {
			resultado += nodo.calcular();
		}
		
		return resultado;
	}

	@Override
	public INodo copy() {
		FuncionSuma copy = new FuncionSuma(this.getRaiz(), this.maximosDescendientes);
		
		for (INodo nodo : this.getDescendientes()) {
			copy.incluirDescendiente(nodo.copy());
		}
		
		return copy;
	}
}
