package adsof1718.grafos.got.simulador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import adsof1718.grafos.Vertice;
import adsof1718.grafos.got.GrafoGOT;
import adsof1718.grafos.got.PersonajeGOT;

public class SimuladorGOT extends Sujeto {

	private GrafoGOT grafo;
	private PersonajeGOT origen;
	private List<PersonajeGOT> destinos;
	private static int N = 10000;

	public SimuladorGOT(GrafoGOT g) {
		super();
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

	public static void main(String...strings) {
		GrafoGOT g;
		
		try {
			g = new GrafoGOT("got-s01-vertices.csv", "got-s01-arcos.csv");
		} catch (IOException e) {
			System.err.println("Error with input files");
			return;
		}
		
		SimuladorGOT simulador = new SimuladorGOT(g);
		new ObservadorGOT(simulador, g.getVertice("Jon Snow").getDatos());
		new ObservadorGOT(simulador, g.getVertice("Daenerys Targaryen").getDatos());
		
		List<String> nombresPersonajes = g.getVertices().stream().map(Vertice<PersonajeGOT>::getDatos)
				.map(PersonajeGOT::getNombre).collect(Collectors.toList());
		
		Random rand = new Random();
		for (int n = 0; n < N; n++) {
			int indiceAleatorio = rand.nextInt(nombresPersonajes.size());
			String nombre = nombresPersonajes.get(indiceAleatorio); // Se elige un personaje de forma aleatoria
			simulador.interaccion(nombre);
			
			if (n % 500 == 0) {
				System.out.println("" + n + " iteraciones completadas");
			}
		}
		
		System.out.println(simulador);
		
	}
}
