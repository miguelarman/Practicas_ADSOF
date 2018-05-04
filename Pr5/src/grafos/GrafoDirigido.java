package grafos;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import aristas.Arista;
import aristas.AristaDirigida;

public class GrafoDirigido<T> extends Grafo<T> {

	@Override
	public void addArco(Vertice<T> v1, Vertice<T> v2, double peso) {
		AristaDirigida<T> a = new AristaDirigida<T>(v1, v2, peso);

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
			AristaDirigida<T> aa = (AristaDirigida<T>) a;

			if (aa.getOrigen().equals(v)) {
				Vertice<T> otroVertice = aa.getDestino();
				
				if (!lista.contains(otroVertice)) {
					lista.add(otroVertice);
				}
			}
		}

		return lista;
	}

}
