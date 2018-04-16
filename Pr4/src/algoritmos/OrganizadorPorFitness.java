package algoritmos;

import java.util.Comparator;

import interfaces.IIndividuo;

public class OrganizadorPorFitness implements Comparator<IIndividuo> {

	@Override
	public int compare(IIndividuo o1, IIndividuo o2) {
		Double fitness1 = o1.getFitness();
		Double fitness2 = o2.getFitness();
		
		return fitness1.compareTo(fitness2);
	}

}
