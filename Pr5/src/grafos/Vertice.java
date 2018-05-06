package grafos;

public class Vertice<T> {

	private T datos;

	public Vertice(T datos) {
		this.datos = datos;
	}
	
	public T getDatos() {
		return this.datos;
	}

	@Override
	public String toString() {
		return this.datos.toString();
	}
}
