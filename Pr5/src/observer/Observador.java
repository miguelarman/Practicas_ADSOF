package observer;

public abstract class Observador {

	public Sujeto sujeto;

	public abstract void actualizar();
	
	@Override
	public abstract String toString();

}
