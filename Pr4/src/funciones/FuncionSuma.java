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
		
		copy.setPadre(this.getPadre());
		
		return copy;
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof FuncionSuma)) {
			return false;
		} else {
			FuncionSuma f = (FuncionSuma) o;
			
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
