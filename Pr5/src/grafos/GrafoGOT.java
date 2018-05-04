package grafos;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

public class GrafoGOT extends GrafoNoDirigido<PersonajeGOT> {

	public GrafoGOT(String ficheroVertices, String ficheroArcos) throws IOException {
		
		// Leemos los vertices
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(ficheroVertices)));
		String linea;
		String[] valores = new String[3];

		while ((linea = reader.readLine()) != null) {
			valores = linea.split(",");

			this.addVertice(Integer.parseInt(valores[0]), new PersonajeGOT(valores[1], valores[2]));
		}
		
		
		// Leemos los arcos
		
		reader = new BufferedReader(new InputStreamReader(new FileInputStream(ficheroArcos)));
		String lineaArcos;
		String[] valoresArcos = new String[3];

		while ((linea = reader.readLine()) != null) {
			valores = linea.split(",");
			
			Vertice<PersonajeGOT> v1 = (Vertice<PersonajeGOT>)this.vertices.get(Integer.parseInt(valores[0]));
			Vertice<PersonajeGOT> v2 = (Vertice<PersonajeGOT>)this.vertices.get(Integer.parseInt(valores[1]));

			this.addArco(v1, v2, Double.parseDouble(valores[2]));
		}
	}

	public Vertice<PersonajeGOT> getVertice(String nombre) {
		// TODO
		return null;
	}

	public List<String> casas() {
		// TODO
		return null;
	}

	public List<String> miembrosCasa(String casa) {
		// TODO
		return null;
	}

	public Map<String, Integer> gradoPersonajes() {
		// TODO
		return null;
	}

	public Map<String, Integer> gradoPonderadoPersonajes() {
		// TODO
		return null;
	}

	public Map<String, Integer> personajesRelevantes() { // No lambda
		// TODO
		return null;
	}

	public static void main(String... strings) {
		// TODO
	}

}
