package funciones;

import java.util.List;

import interfaces.INodo;

public class FuncionMultiplicacion extends Funcion {

	public FuncionMultiplicacion(String raiz, int i) {
		super(raiz, i);
	}

	@Override
	public double calcular() {
		double resultado = 1.0;
		
		List<INodo> descendientes = this.getDescendientes();
		
		for (INodo nodo : descendientes) {
			resultado *= nodo.calcular();
		}
		
		return resultado;
	}

	@Override
	public INodo copy() {
		FuncionMultiplicacion copy = new FuncionMultiplicacion(this.getRaiz(), this.maximosDescendientes);
		
		for (INodo nodo : this.getDescendientes()) {
			copy.incluirDescendiente(nodo.copy());
		}
		
		copy.setPadre(this.getPadre());
		
		return copy;
	}
}
