package grafos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Grafo<T> {
	protected Map<Integer, Vertice<T>> vertices;
	private int numVertices = 0;

	public Grafo() {
		this.vertices = new HashMap<Integer, Vertice<T>>();
	}

	public Vertice<T> addVertice(T datos) {
		Vertice<T> vertice = new Vertice<T>(datos);
		
		int id = numVertices;
		
		while(this.vertices.containsKey(id)) {
			id++;
		}
		this.vertices.put(id, vertice);
		
		numVertices++;
		
		return vertice;
	}

	protected Vertice<T> addVertice(int id, T datos) {
		Vertice<T> vertice = new Vertice<T>(datos);
		
		if (this.vertices.containsKey(id)) {
			// TODO
		} else {
			this.vertices.put(id, vertice);
		}
		
		return vertice;
	}

	public List<Vertice<T>> getVertices() {
		// TODO
		return null;
	}

	public int getNumVertices() {
		return numVertices;
	}

	public abstract void addArco(Vertice<T> v1, Vertice<T> v2, double peso);

	public boolean existeArco(Vertice<T> v1, Vertice<T> v2) {
		// TODO
		return false;
	}

	public int getNumArcos() {
		// TODO
		return -1;
	}

	public abstract double getPesoDe(Vertice<T> v1, Vertice<T> v2);

	public abstract List<Vertice<T>> getVecinosDe(Vertice<T> v); // devuelve los v�rtices que tienen un arco con v (en
																	// grafo dirigido, v ha de ser origen de los arcos)

	public String toString() { // los v�rtices del grafo han de presentarse ORDENADOS POR IDENTIFICADOR
		// TODO
		return null;
	}
}
