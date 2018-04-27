package grafos;

public class AristaNoDirigida<T> extends Arista<T> {

	private Vertice<T> vertice1;
	private Vertice<T> vertice2;

	public AristaNoDirigida(Vertice<T> v1, Vertice<T> v2, double peso) {
		super(peso);

		this.vertice1 = v1;
		this.vertice2 = v2;
	}

	@Override
	public boolean conecta(Vertice<T> v1, Vertice<T> v2) {
		if (this.vertice1.equals(v1) && this.vertice2.equals(v2)) {
			return true;
		} else if (this.vertice1.equals(v2) && this.vertice2.equals(v1)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean contiene(Vertice<T> v) {
		if (this.vertice1.equals(v) || this.vertice2.equals(v)) {
			return true;
		} else {
			return false;
		}
	}

	public Vertice<T> getOtro(Vertice<T> v) {
		if (this.vertice1.equals(v)) {
			return this.vertice2;
		} else if (this.vertice2.equals(v)) {
			return this.vertice1;
		} else {
			return null;
		}
	}

}
