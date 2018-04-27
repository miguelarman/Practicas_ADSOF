package grafos;

public class AristaDirigida<T> extends Arista<T> {

	private Vertice<T> origen;
	private Vertice<T> destino;

	public AristaDirigida(Vertice<T> v1, Vertice<T> v2, double peso) {
		super(peso);
		
		this.origen = v1;
		this.destino = v2;
	}

	@Override
	public boolean conecta(Vertice<T> v1, Vertice<T> v2) {
		if (v1.equals(this.origen) && v2.equals(this.destino)) {
			return true;
		} else {
			return false;
		}
	}

	public Vertice<T> getOrigen() {
		return this.origen;
	}
	
	public Vertice<T> getDestino() {
		return this.destino;
	}

}
