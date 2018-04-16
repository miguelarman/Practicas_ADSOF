package algoritmos;

import java.util.Comparator;

import interfaces.IIndividuo;

public class OrganizadorPorFitness implements Comparator<IIndividuo> {

	@Override
	public int compare(IIndividuo o1, IIndividuo o2) {
		Double fitness1 = o1.getFitness();
		Double fitness2 = o2.getFitness();
		
//		if (fitness2.compareTo(fitness1) != 0) {
			return fitness2.compareTo(fitness1);
//		} else {
//			Integer numeroNodos1 = o1.getNumeroNodos();
//			Integer numeroNodos2 = o2.getNumeroNodos();
//			
//			return numeroNodos1.compareTo(numeroNodos2);
//		}
	}

}
