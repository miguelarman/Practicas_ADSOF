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
		
		if(randomNum1 == 0 && randomNum2 == 0) {
			List<IIndividuo> lista = new ArrayList<IIndividuo>();
			lista.add(prog1);
			lista.add(prog2);
			throw new CruceNuloException(lista);
		} else if (randomNum1 == 0) {
			// TODO
			return null;
		} else if (randomNum2 == 0) {
			// TODO 
			return null;
		} else {
		
		IIndividuo nuevo1 = prog1.copy();
		IIndividuo nuevo2 = prog2.copy();
		
		
		INodo n1 = nuevo1.getEtiquetas().get(randomNum1);
		INodo n2 = nuevo2.getEtiquetas().get(randomNum2);		
				
		System.out.println(n1 + " " + n2);
		
		INodo padre1 = n1.getPadre();
		INodo padre2 = n2.getPadre();
		
		
		
		System.out.println(padre1.getDescendientes() + " " + padre2.getDescendientes());
		
		
		int indice1 = padre1.getDescendientes().indexOf(n1);
		int indice2 = padre2.getDescendientes().indexOf(n2);
		
		System.out.println(indice1 + " " + indice2);
		

		INodo aux1 = n1.copy();
		INodo aux2 = n2.copy();
		aux1.setPadre(padre2);
		aux2.setPadre(padre1);
		
		padre1.getDescendientes().remove(indice1);
		padre1.getDescendientes().add(indice1, aux2.copy());
		
		padre2.getDescendientes().remove(indice2);
		padre2.getDescendientes().add(indice2, aux1.copy());
		
//		padre1.getDescendientes().remove(n1);
//		padre2.getDescendientes().remove(n2);
//		padre1.getDescendientes().add(1, aux2.copy());
//		padre2.getDescendientes().add(1, aux1.copy());
		
		List<IIndividuo> nuevos = new ArrayList<IIndividuo>();
		nuevos.add(nuevo1);
		nuevos.add(nuevo2);
		
		return nuevos;
	}
	}

}
