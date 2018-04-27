package grafos;

public class Vertice<T> {

	private T datos;

	public Vertice(T datos) {
		this.datos = datos;
	}

	@Override
	public String toString() {
		return this.datos.toString();
	}
}
