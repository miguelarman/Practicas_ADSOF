package grafos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aristas.Arista;
import interfaces.IGrafo;

public abstract class Grafo<T> implements IGrafo<T>{
	protected Map<Integer, Vertice<T>> vertices;
	protected Map<Integer, Arista<T>> aristas;
	protected int numVertices = 0;
	protected int numAristas = 0;

	public Grafo() {
		this.vertices = new HashMap<Integer, Vertice<T>>();
		this.aristas = new HashMap<Integer, Arista<T>>();
	}

	public Vertice<T> addVertice(T datos) {
		Vertice<T> vertice = new Vertice<T>(datos);
		
		// TODO comprobar si ya está

		int id = numVertices + 1;

		while (this.vertices.containsKey(id)) {
			id++;
		}
		this.vertices.put(id, vertice);

		numVertices++;

		return vertice;
	}

	public Vertice<T> addVertice(int id, T datos) {
		Vertice<T> vertice = new Vertice<T>(datos);
		
		if (this.vertices.containsKey(id)) {
			throw new IllegalArgumentException();
		} else {
			this.vertices.put(id, vertice);
		}

		return vertice;
	}

	public List<Vertice<T>> getVertices() {
		return (List<Vertice<T>>) this.vertices.values();
	}

	public int getNumVertices() {
		return numVertices;
	}
	
	public abstract void addArco(Vertice<T> v1, Vertice<T> v2, double peso);

	public boolean existeArco(Vertice<T> v1, Vertice<T> v2) {
		for (Arista<T> arista : this.aristas.values()) {
			if (arista.conecta(v1, v2)) {
				return true;
			}
		}
		
		return false;
	}

	public int getNumArcos() {
		return this.aristas.size();
	}

	public abstract double getPesoDe(Vertice<T> v1, Vertice<T> v2);

	public abstract List<Vertice<T>> getVecinosDe(Vertice<T> v);

	public String toString() { // los vértices del grafo han de presentarse ORDENADOS POR IDENTIFICADOR
		
		String cadena = "";
		
		for (Integer i : this.vertices.keySet()) {
			Vertice<T> vertice = this.vertices.get(i);
			
			cadena += "Vertice " + i + ": " + vertice + "\n";
		}
		
		return cadena;
		
	}
}
