package adsof1718.grafos;

public abstract class Arista<T> {
	
	private Double peso;

	public Arista(double peso) {
		this.peso = peso;
	}

	public abstract boolean conecta(Vertice<T> v1, Vertice<T> v2);

	public double getPeso() {
		return this.peso;
	}

}
