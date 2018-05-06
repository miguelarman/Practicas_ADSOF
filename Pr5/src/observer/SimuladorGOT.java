package observer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import grafos.GrafoGOT;
import grafos.PersonajeGOT;
import grafos.Vertice;

public class SimuladorGOT extends Sujeto {

	private GrafoGOT grafo;
	private PersonajeGOT origen;
	private List<PersonajeGOT> destinos;

	public SimuladorGOT(GrafoGOT g) {
		this.grafo = g;
	}

	public PersonajeGOT getOrigen() {
		return this.origen;
	}

	public List<PersonajeGOT> getDestinos() {
		return this.destinos;
	}
	
	public void interaccion(String nombre) {
		Vertice<PersonajeGOT> origen = this.grafo.getVertice(nombre);
		this.origen = origen.getDatos();
		
		this.destinos = new ArrayList<PersonajeGOT>();
		List<Vertice<PersonajeGOT>> vecinos = this.grafo.getVecinosDe(origen);
		Integer pesosVecinos = this.grafo.gradoPonderadoPersonajes().get(origen.getDatos().getNombre());
		Random rand = new Random();
		
		vecinos.stream().forEach(v -> {
			Double p = this.grafo.getPesoDe(origen, v) / pesosVecinos;
			Double r = rand.nextDouble();
			
			if (r < p) {
				destinos.add(v.getDatos());
			}
		});
		
		if (destinos.size() > 0) {
			super.notificar();
		}
	}
	
	@Override
	public String toString() {
		// TODO
		return null;
	}

	public static void main(String...strings) {
		int N = 10000;
		GrafoGOT g;
		try {
			g = new GrafoGOT("got-s01-vertices.csv", "got-s01-arcos.csv");
		} catch (IOException e) {
			System.err.println("Error with input files");
			return;
		}
		SimuladorGOT simulador = new SimuladorGOT(g);
		
		List<String> casas = g.casas();
		List<String> nombresPersonajes = new ArrayList<String>(); // Lista de personajes
		casas.stream().forEach(c -> {
			nombresPersonajes.addAll(g.miembrosCasa(c));
		});
		
		Random rand = new Random();
		for (int n = 0; n < N; n++) {
			int indiceAleatorio = rand.nextInt(nombresPersonajes.size());
			String nombre = nombresPersonajes.get(indiceAleatorio); // Se elige un personaje de forma aleatoria
			simulador.interaccion(nombre);	
		}
		
		System.out.println(simulador);
	}
}
