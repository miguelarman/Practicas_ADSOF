package funciones;

import interfaces.INodo;

/**
 * Clase que implementa la funcion aritmetica <b>resta</b>
 * 
 * @author Miguel Arconada (miguel.arconada@estudiante.uam.es) Alberto Gonzalez (alberto.gonzalezk@estudiante.uam.es)
 */
public class FuncionResta extends Funcion {

	/**
	 * Metodo constructor de la clase FuncionResta
	 * 
	 * @param raiz Simbolo del nodo
	 * @param i Numero maximo de descendientes
	 */
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
		
		copy.setPadre(this.getPadre());
		
		copy.actualizarPadres();
		
		return copy;
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof FuncionResta)) {
			return false;
		} else {
			FuncionResta f = (FuncionResta) o;
			
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
