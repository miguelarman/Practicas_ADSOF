package grafos;

import factoria.FactoriaGrafos;
import interfaces.IGrafo;

public class GrafoCompletamenteConectado<T> extends GrafoNoDirigido<T>{
	
	@Override
	public Vertice<T> addVertice(T datos) {
		Vertice<T> vertice = new Vertice<T>(datos);
		
		// TODO comprobar si ya est�
		
		vertices.values().stream().forEach(v -> {
			this.addArco(v, vertice, 0);
			numAristas++;
		});
		
		int id = numVertices + 1;

		while (this.vertices.containsKey(id)) {
			id++;
		}
		this.vertices.put(id, vertice);
		
		numVertices++;

		return vertice;
	}
	
	public static void main(String...strings) {
//		IGrafo<Integer> g = FactoriaGrafos.<Integer>crearGrafo(FactoriaGrafos.TiposGrafo.NO_DIRIGIDO);
//		IGrafo<Integer> g = FactoriaGrafos.<Integer>crearGrafo(FactoriaGrafos.TiposGrafo.DIRIGIDO);
		IGrafo<Integer> g = FactoriaGrafos.<Integer>crearGrafo(FactoriaGrafos.TiposGrafo.COMPLETAMENTE_CONECTADO);
		Vertice<Integer> v1 = g.addVertice(10);
		Vertice<Integer> v2 = g.addVertice(20);
		Vertice<Integer> v3 = g.addVertice(30);
		g.addArco(v1, v2, 0);
		g.addArco(v1, v3, 0);
		System.out.println(g);
		System.out.println("existe_arco(" + v1 + "," + v2 + ") = " + g.existeArco(v1, v2));
		System.out.println("existe_arco(" + v2 + "," + v1 + ") = " + g.existeArco(v2, v1));

	}
}
