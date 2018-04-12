package funciones;

import interfaces.INodo;

public class FuncionResta extends Funcion {

	public FuncionResta(String raiz, int i) {
		super(raiz, i);
	}

	@Override
	public double calcular() {
		double resultado = 0.0;
				
		for (int i = 0; i < this.getDescendientes().size(); i++) {
			if (i == 0) {
				resultado += this.getDescendientes().get(i).calcular();
			} else {
				resultado -= this.getDescendientes().get(i).calcular();
			}
		}
		
		return resultado;
	}

	@Override
	public INodo copy() {
		FuncionResta copy = new FuncionResta(this.getRaiz(), this.maximosDescendientes);
		
		for (INodo nodo : this.getDescendientes()) {
			copy.incluirDescendiente(nodo.copy());
		}
		
		return copy;
	}
}
