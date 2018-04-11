package cruce;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import interfaces.IIndividuo;
import interfaces.INodo;

public class PruebaCruce {

	public List<IIndividuo> cruce(IIndividuo prog1, IIndividuo prog2) {
		int randomNum1 = ThreadLocalRandom.current().nextInt(0, prog1.getNumeroNodos());
		int randomNum2 = ThreadLocalRandom.current().nextInt(0, prog2.getNumeroNodos());
		
		INodo n1 = prog1.getEtiquetas().get(randomNum1);
		
		
		return null;
	}

}
