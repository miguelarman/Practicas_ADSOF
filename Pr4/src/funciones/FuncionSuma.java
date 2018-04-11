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
		// TODO Auto-generated method stub
		return null;
	}
}
