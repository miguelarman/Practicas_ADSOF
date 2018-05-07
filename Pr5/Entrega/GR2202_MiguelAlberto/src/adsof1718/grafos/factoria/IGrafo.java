package adsof1718.grafos.factoria;

import java.util.List;

import adsof1718.grafos.Vertice;

public interface IGrafo<T> {
	
	public Vertice<T> addVertice(T datos);
	
	public Vertice<T> addVertice(int id, T datos);
	
	public List<Vertice<T>> getVertices();
	
	public int getNumVertices();
	
	public void addArco(Vertice<T> v1, Vertice<T> v2, double peso);
	
	public boolean existeArco(Vertice<T> v1, Vertice<T> v2);
	
	public int getNumArcos();
	
	public double getPesoDe(Vertice<T> v1, Vertice<T> v2);
	
	public List<Vertice<T>> getVecinosDe(Vertice<T> v);
}
