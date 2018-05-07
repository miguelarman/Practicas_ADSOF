package adsof1718.grafos.factoria;

import adsof1718.grafos.GrafoDirigido;
import adsof1718.grafos.GrafoNoDirigido;

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
