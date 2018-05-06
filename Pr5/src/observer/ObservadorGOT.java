package observer;

import java.util.List;

import grafos.PersonajeGOT;

public class ObservadorGOT extends Observador {
	private SimuladorGOT simulador;
	private PersonajeGOT personaje;

	public ObservadorGOT(SimuladorGOT s, PersonajeGOT p) {
		this.simulador = s;
		this.personaje = p;
	}
	
	public void actualizar() {
	 SimuladorGOT simulador = (SimuladorGOT) super.sujeto;
	 PersonajeGOT origen = simulador.getOrigen();
	 List<PersonajeGOT> destinos = simulador.getDestinos();
	 // TODO
	}
}
