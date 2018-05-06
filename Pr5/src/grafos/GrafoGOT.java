package grafos;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GrafoGOT extends GrafoNoDirigido<PersonajeGOT> {

	public GrafoGOT(String ficheroVertices, String ficheroArcos) throws IOException {
		
		// Leemos los vertices
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(ficheroVertices)));
		String linea;
		String[] valores = new String[3];

		while ((linea = reader.readLine()) != null) {
			valores = linea.split(",");
			
			if (valores[2].equals("null")) {
				valores[2] = null;
			}

			this.addVertice(Integer.parseInt(valores[0]), new PersonajeGOT(valores[1], valores[2]));
		}
		
		reader.close();
		
		// Leemos los arcos
		
		reader = new BufferedReader(new InputStreamReader(new FileInputStream(ficheroArcos)));

		String lineaArcos;
		String[] valoresArcos = new String[3];

		while ((lineaArcos = reader.readLine()) != null) {
			valoresArcos = lineaArcos.split(",");
			
			Vertice<PersonajeGOT> v1 = (Vertice<PersonajeGOT>)this.vertices.get(Integer.parseInt(valoresArcos[0]));
			Vertice<PersonajeGOT> v2 = (Vertice<PersonajeGOT>)this.vertices.get(Integer.parseInt(valoresArcos[1]));

			this.addArco(v1, v2, Double.parseDouble(valoresArcos[2]));
		}
		
		reader.close();
	}

	public Vertice<PersonajeGOT> getVertice(String nombre) {
		Optional<Vertice<PersonajeGOT>> resultado = this.vertices.values().stream().filter(v -> v.getDatos().getNombre().equals(nombre)).findFirst();
		
		return resultado.orElse(null);
	}

	public List<String> casas() {
		Set<String> conjunto = this.vertices.values().stream().map(Vertice<PersonajeGOT>::getDatos).map(PersonajeGOT::getCasa).filter(nombre -> nombre != null).collect(Collectors.toSet());
		
		List<String> lista = new ArrayList<String>();
		lista.addAll(conjunto);
		
		lista.sort(null);
		return lista;
	}

	public List<String> miembrosCasa(String casa) {

		
//		Predicate<PersonajeGOT> esMiembro = p -> p.getCasa().equals(casa);
//		return this.vertices.values().stream().map(Vertice<PersonajeGOT>::getDatos).filter(esMiembro).map(PersonajeGOT::getNombre).collect(Collectors.toList());
		
		return this.vertices.values().stream().map(Vertice<PersonajeGOT>::getDatos).filter(new Predicate<PersonajeGOT>() {
			@Override
			public boolean test (PersonajeGOT p) {
				if (p.getCasa() == null) {
					return false;
				} else {
					return p.getCasa().equals(casa);
				}
			}
		}).map(PersonajeGOT::getNombre).collect(Collectors.toList());
	}

	public Map<String, Integer> gradoPersonajes() {
		List<String> nombres = this.vertices.values().stream().map(Vertice<PersonajeGOT>::getDatos).map(PersonajeGOT::getNombre).collect(Collectors.toList());
		
		List<Integer> grados = new ArrayList<>();
		
		this.vertices.values().stream().forEach(v -> {
			grados.add(this.getVecinosDe(v).size());
		});
		
		HashMap<String, Integer> mapa = new HashMap<>();
		for (int i = 0; i < nombres.size(); i++) {
			mapa.put(nombres.get(i), grados.get(i));
		}
		
		return mapa;
	}

	public Map<String, Integer> gradoPonderadoPersonajes() {
		List<String> nombres = this.vertices.values().stream().map(Vertice<PersonajeGOT>::getDatos).map(PersonajeGOT::getNombre).collect(Collectors.toList());
		
		List<Integer> pesos = new ArrayList<>();

		this.vertices.values().stream().forEach(v -> {
			List<Vertice<PersonajeGOT>> vecinos = this.getVecinosDe(v);
	
			List<Double> listaPesosVecinos = new ArrayList<>();
			vecinos.stream().forEach(ve -> {
				listaPesosVecinos.add(this.getPesoDe(v, ve));
			});
			
			Double suma = listaPesosVecinos.stream().reduce(0.0, Double::sum);
			
			pesos.add(suma.intValue());
		});
		
		HashMap<String, Integer> mapa = new HashMap<>();
		for (int i = 0; i < nombres.size(); i++) {
			mapa.put(nombres.get(i), pesos.get(i));
		}
		
		return mapa;
	}

	public Map<String, Integer> personajesRelevantes() {
		Map<String, Integer> mapaGeneral = this.gradoPonderadoPersonajes();
		Double avg = mapaGeneral.values().stream().mapToInt(Integer::intValue).average().orElse(0);
		
//		Map<String, Integer> mapaFinal = new HashMap<>();
//		mapaGeneral.entrySet().stream().filter(new Predicate<Entry<String, Integer>>(){
//			@Override
//			public boolean test(Entry<String, Integer> e) {
//				return e.getValue() > avg;
//			}
//		}).forEach(entry -> {
//			mapaFinal.put(entry.getKey(), entry.getValue());
//		});
//		
//		return mapaFinal;
		
		return mapaGeneral.entrySet().stream().filter(new Predicate<Entry<String, Integer>>(){
			@Override
			public boolean test(Entry<String, Integer> e) {
				return e.getValue() > avg;
			}
		}).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
	}

	public static void main(String... strings) throws IOException {
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
		System.out.println(personajesRelevantes);	}

}
