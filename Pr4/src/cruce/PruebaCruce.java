package cruce;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import excepciones.CruceNuloException;
import interfaces.IIndividuo;
import interfaces.INodo;

public class PruebaCruce {

	public List<IIndividuo> cruce(IIndividuo prog1, IIndividuo prog2) throws CruceNuloException{
		int randomNum1 = ThreadLocalRandom.current().nextInt(0, prog1.getNumeroNodos());
		int randomNum2 = ThreadLocalRandom.current().nextInt(0, prog2.getNumeroNodos());
		
		if(randomNum1 == 1 && randomNum2 == 1) {
			List<IIndividuo> lista = new ArrayList<IIndividuo>();
			lista.add(prog1);
			lista.add(prog2);
			throw new CruceNuloException();
		}
		INodo n1 = prog1.getEtiquetas().get(randomNum1);
		INodo n2 = prog2.getEtiquetas().get(randomNum2);
		
		INodo nodoAux = n1.copy();
		n1 = n2.copy();
		n2 = nodoAux.copy();
		
		return null;
	}

}
