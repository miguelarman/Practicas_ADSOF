package adsof1718.grafos.got.simulador;

public abstract class Observador {

	public Sujeto sujeto;

	public Observador(Sujeto s) {
		this.sujeto = s;
	}

	public abstract void actualizar();
	
	@Override
	public abstract String toString();

}
