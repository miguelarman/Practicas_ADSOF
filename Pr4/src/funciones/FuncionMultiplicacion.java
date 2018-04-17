package funciones;

import java.util.List;

import interfaces.INodo;

/**
 * Clase que implementa la funcion aritmetica <b>multiplicacion</b>
 * 
 * @author Miguel Arconada (miguel.arconada@estudiante.uam.es) Alberto Gonzalez (alberto.gonzalezk@estudiante.uam.es)
 */
public class FuncionMultiplicacion extends Funcion {

	/**
	 * Constructor de la clase FuncionMultiplicacion
	 * 
	 * @param raiz Raiz del nodo
	 * @param i Numero maximo de descendientes
	 */
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
