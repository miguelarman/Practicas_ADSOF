package observer;

import java.util.List;

import grafos.GrafoGOT;
import grafos.PersonajeGOT;

public class SimuladorGOT extends Sujeto {

	private GrafoGOT grafo;

	public SimuladorGOT(GrafoGOT g) {
		this.grafo = g;
	}

	public PersonajeGOT getOrigen() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PersonajeGOT> getDestinos() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void interaccion(String nombre) {
		// TODO
	}
	
	@Override
	public String toString() {
		// TODO
		return null;
	}

	public static void main(String...strings) {
		int N = 10000;
		// TODO
		GrafoGOT g = null;// TODO
		SimuladorGOT simulador = new SimuladorGOT(g);
		// TODO
		List<String> nombresPersonajes = null; // TODO lista de personajes
		for (int n = 0; n < N; n++) {
		 String nombre = nombresPersonajes.get(-1); // TODO se elige un personaje de forma aleatoria
		 simulador.interaccion(nombre);
		}
		// TODO
	}
}
