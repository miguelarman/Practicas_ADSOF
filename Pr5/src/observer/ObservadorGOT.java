package observer;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import grafos.PersonajeGOT;

public class ObservadorGOT extends Observador {
	private SimuladorGOT simulador;
	private PersonajeGOT personaje;
	private HashMap<String, Integer> interacciones;

	public ObservadorGOT(SimuladorGOT s, PersonajeGOT p) {
		super(s);
		
		// TODO Borrar esto porque ya se consigue en la super
		this.simulador = s;
		this.personaje = p;
		
		s.addObservador(this);
		
		this.interacciones = new HashMap<String, Integer>();
	}
	
	@Override
	public void actualizar() {
		SimuladorGOT simulador = (SimuladorGOT) super.sujeto;
		PersonajeGOT origen = simulador.getOrigen();
		List<PersonajeGOT> destinos = simulador.getDestinos();

		if (origen.equals(this.personaje)) {
			destinos.stream().forEach(d -> {
				if (this.interacciones.containsKey(d.getCasa())) {
					this.interacciones.put(d.getCasa(), this.interacciones.get(d.getCasa()) + 1);
				} else {
					this.interacciones.put(d.getCasa(), 1);
				}
			});
		}
	}

	@Override
	public String toString() {
		String string = "";
		
		string += this.personaje.getNombre();
		
		Integer interaccionesTotales = this.interacciones.values().stream().reduce(0, Integer::sum);
		Integer interaccionesInternas = this.interacciones.get(this.personaje.getCasa());
		if (interaccionesInternas == null) {
			interaccionesInternas = 0;
		}
		
		string += "\n\tInteracciones: " + interaccionesTotales;
		string += "\n\t\tCon miembros de su casa: " + interaccionesInternas;
		string += "\n\t\tCon miembros de casa ajena:";
		
		string += this.interacciones.entrySet().stream().filter(new Predicate<Entry<String, Integer>>() {
			@Override
			public boolean test(Entry<String, Integer> e) {
				
				if (personaje.getCasa() == null) {
					return true;
				} else if (e.getKey() == null) {
					 return true;
				} else {
					return !e.getKey().equals(personaje.getCasa());
				}
			}
		}) .map(new Function<Entry<String, Integer>, String>() {

			@Override
			public String apply(Entry<String, Integer> e) {
				if (e.getKey() == null) {
					return "\n\t\t\tSin casa: " + e.getValue();
				} else {
					return "\n\t\t\t" + e.getKey() + ": " + e.getValue();
				}
			}
			
		}).collect(Collectors.joining(""));
		
		
		return string;
	}
}
