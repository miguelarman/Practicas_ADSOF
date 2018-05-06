package testers;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import grafos.GrafoGOT;

public class TesterApartado2 {
	public static void main(String...strings) throws IOException {
		GrafoGOT grafo = new GrafoGOT("got-s01-vertices.csv", "got-s01-arcos.csv");
		
		List<String> casas = grafo.casas();
		System.out.println(casas);
		
		List<String> miembrosCasa = grafo.miembrosCasa("Stark");
		System.out.println(miembrosCasa);
		
		Map<String, Integer> gradoPersonajes = grafo.gradoPersonajes();
		System.out.println(gradoPersonajes);
		
		Map<String, Integer> gradoPonderadoPersonajes = grafo.gradoPonderadoPersonajes();
		System.out.println(gradoPonderadoPersonajes);
		
		Map<String, Integer> personajesRelevantes = grafo.personajesRelevantes();
		System.out.println(personajesRelevantes);
		
	}
}
