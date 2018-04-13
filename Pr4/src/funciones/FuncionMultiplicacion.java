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
		
		copy.actualizarPadres();
		
		return copy;
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof FuncionMultiplicacion)) {
			return false;
		} else {
			FuncionMultiplicacion f = (FuncionMultiplicacion) o;
			
			if (f.maximosDescendientes != this.maximosDescendientes) {
				return false;
			} else if (f.getRaiz().compareTo(this.getRaiz()) != 0) {
				return false;
			} else {
				if (f.getDescendientes().size() != this.getDescendientes().size()) {
					return false;
				} else {
					for (int i = 0; i < f.getDescendientes().size(); i++) {
						if (!(this.getDescendientes().get(i)).equals(f.getDescendientes().get(i))) {
							return false;
						}
					}
				}
			}
		}
		
		return true;
	}
}
