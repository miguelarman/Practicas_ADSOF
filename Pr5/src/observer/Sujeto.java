package observer;

import java.util.List;

public abstract class Sujeto {
	
	List<Observador> observadores;
	
	public void addObservador(Observador o) {
		this.observadores.add(o);
	}
	
	public void notificar() {
		observadores.stream().forEach(o -> {
			o.actualizar();
		});
	}
	
	@Override
	public String toString() {
		String string = "";
		
		for (Observador o : this.observadores) {
			string += o.toString() + "\n";
		}
		
		return string;
	}
}
