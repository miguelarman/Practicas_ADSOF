package observer;

import java.util.HashMap;
import java.util.List;

import grafos.PersonajeGOT;

public class ObservadorGOT extends Observador {
	private SimuladorGOT simulador;
	private PersonajeGOT personaje;
	private HashMap<PersonajeGOT, Integer> interacciones;

	public ObservadorGOT(SimuladorGOT s, PersonajeGOT p) {
		this.simulador = s;
		this.personaje = p;
		
		this.interacciones = new HashMap<PersonajeGOT, Integer>();
	}
	
	@Override
	public void actualizar() {
		SimuladorGOT simulador = (SimuladorGOT) super.sujeto;
		PersonajeGOT origen = simulador.getOrigen();
		List<PersonajeGOT> destinos = simulador.getDestinos();

		if (origen.equals(this.personaje)) {
			destinos.stream().forEach(d -> {
				if (this.interacciones.containsKey(d)) {
					this.interacciones.put(d, this.interacciones.get(d) + 1);
				} else {
					this.interacciones.put(d, 1);
				}
			});
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
}
