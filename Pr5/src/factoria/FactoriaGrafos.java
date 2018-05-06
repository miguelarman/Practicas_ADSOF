package factoria;

import grafos.GrafoCompletamenteConectado;
import grafos.GrafoDirigido;
import grafos.GrafoNoDirigido;
import interfaces.IGrafo;

public class FactoriaGrafos<T> {
	
	public enum TiposGrafo {
		 DIRIGIDO, NO_DIRIGIDO, COMPLETAMENTE_CONECTADO;
	}
	public static <T> IGrafo<T> crearGrafo(TiposGrafo tipoGrafo) throws IllegalArgumentException{
		switch(tipoGrafo) {
		case DIRIGIDO:
			return new GrafoDirigido<T>();
		case NO_DIRIGIDO:
			return new GrafoNoDirigido<T>();
		case COMPLETAMENTE_CONECTADO:
			return new GrafoCompletamenteConectado<T>();
		default:
			return null;
		}
	
	}

}
