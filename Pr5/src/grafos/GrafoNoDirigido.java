package grafos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GrafoNoDirigido<T> extends Grafo<T> {

	@Override
	public void addArco(Vertice<T> v1, Vertice<T> v2, double peso) {
		AristaNoDirigida<T> a = new AristaNoDirigida<T>(v1, v2, peso);

		this.numAristas++;

		this.aristas.put(this.numAristas, a);
	}

	@Override
	public double getPesoDe(Vertice<T> v1, Vertice<T> v2) {
		Double total = 0.0;

		for (Arista<T> a : this.aristas.values()) {
			if (a.conecta(v1, v2)) {
				total += a.getPeso();
			}
		}

		return total;
	}

	@Override
	public List<Vertice<T>> getVecinosDe(Vertice<T> v) {
		List<Vertice<T>> lista = new ArrayList<Vertice<T>>();

		for (Arista<T> a : this.aristas.values()) {
			AristaNoDirigida<T> aa = (AristaNoDirigida<T>) a;

			if (aa.contiene(v)) {
				Vertice<T> otroVertice = aa.getOtro(v);
				
				if (!lista.contains(otroVertice)) {
					lista.add(otroVertice);
				}
			}
		}

		return lista;
	}

}
