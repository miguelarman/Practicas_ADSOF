package cruce;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import excepciones.CruceNuloException;

import interfaces.IIndividuo;
import interfaces.INodo;

/**
 * Clase utilizada para probar el cruce de individuos
 * 
 * @author Miguel Arconada (miguel.arconada@estudiante.uam.es) Alberto Gonzalez (alberto.gonzalezk@estudiante.uam.es)
 */
public class PruebaCruce {

	/**
	 * Metodo que cruza dos individuos de forma aleatoria
	 * 
	 * @param prog1 Primer individuo a cruzar
	 * @param prog2 Segundo individuo a cruzar 
	 * 
	 * @throws CruceNuloException Cuando se intenta cruzar la raiz de ambos individuos
	 * 
	 * @return Individuos generados por el cruce
	 */
	public List<IIndividuo> cruce(IIndividuo prog1, IIndividuo prog2) throws CruceNuloException {
		int randomNum1 = ThreadLocalRandom.current().nextInt(0, prog1.getNumeroNodos());
		int randomNum2 = ThreadLocalRandom.current().nextInt(0, prog2.getNumeroNodos());

		System.out.println("Punto de cruce del progenitor 1: " + randomNum1);
		System.out.println("Punto de cruce del progenitor 2: " + randomNum2);

		if (randomNum1 == 0 && randomNum2 == 0) {
			List<IIndividuo> lista = new ArrayList<IIndividuo>();
			lista.add(prog1);
			lista.add(prog2);
			throw new CruceNuloException(lista);
		} else if (randomNum1 == 0) {
			
			IIndividuo nuevo1 = prog1.copy();
			IIndividuo nuevo2 = prog2.copy();
			
			nuevo1.etiquetaNodos(); nuevo2.etiquetaNodos();
			
			INodo n1 = nuevo1.getEtiquetas().get(randomNum1);
			INodo n2 = nuevo2.getEtiquetas().get(randomNum2);
			
			INodo padre2 = n2.getPadre();
			
			int indice2 = -1;
			for (int i = 0; i < padre2.getDescendientes().size(); i++) {
				if (n2 == padre2.getDescendientes().get(i)) {
					indice2 = i;
				}
			}
			
//			System.out.println(n2);
//			System.out.println(padre2.getDescendientes());
			
			INodo aux1 = n1.copy(); INodo aux2 = n2.copy();
			aux1.setPadre(padre2); aux2.setPadre(null);
			
			nuevo1.setExpresion(aux2);
			
			padre2.getDescendientes().remove(indice2);
			padre2.getDescendientes().add(indice2, aux1.copy());
			 
			nuevo1.etiquetaNodos();
			nuevo2.etiquetaNodos();
			
			
			List<IIndividuo> nuevos = new ArrayList<IIndividuo>();
			nuevos.add(nuevo1);
			nuevos.add(nuevo2);
			return nuevos;
			
		} else if (randomNum2 == 0) {
			
			IIndividuo nuevo1 = prog1.copy();
			IIndividuo nuevo2 = prog2.copy();
			
			nuevo1.etiquetaNodos(); nuevo2.etiquetaNodos();
			
			INodo n1 = nuevo1.getEtiquetas().get(randomNum1);
			INodo n2 = nuevo2.getEtiquetas().get(randomNum2);
			
			INodo padre1 = n1.getPadre();
			
			int indice1 = -1;
			for (int i = 0; i < padre1.getDescendientes().size(); i++) {
				if (n1 == padre1.getDescendientes().get(i)) {
					indice1 = i;
				}
			}
			
//			System.out.println(n1);
//			System.out.println(padre1.getDescendientes());
			
			INodo aux1 = n1.copy(); INodo aux2 = n2.copy();
			aux1.setPadre(null); aux2.setPadre(padre1);
			
			nuevo2.setExpresion(aux1);
			
			padre1.getDescendientes().remove(indice1);
			padre1.getDescendientes().add(indice1, aux2.copy());
			 
			nuevo1.etiquetaNodos();
			nuevo2.etiquetaNodos();
			
			
			List<IIndividuo> nuevos = new ArrayList<IIndividuo>();
			nuevos.add(nuevo1);
			nuevos.add(nuevo2);
			return nuevos;
			
		} else {

			IIndividuo nuevo1 = prog1.copy();
			IIndividuo nuevo2 = prog2.copy();
			
			nuevo1.etiquetaNodos();
			nuevo2.etiquetaNodos();

			INodo n1 = nuevo1.getEtiquetas().get(randomNum1);
			INodo n2 = nuevo2.getEtiquetas().get(randomNum2);

			INodo padre1 = n1.getPadre();	//System.out.println(padre1.getDescendientes().contains(n1));
			INodo padre2 = n2.getPadre();
			
//			System.out.println(n1);
//			System.out.println(padre1.getDescendientes());
			
//			System.out.println((n1 == padre1.getDescendientes().get(0)) + " " + (n1 == padre1.getDescendientes().get(1)));
			int indice1 = -1, indice2 = -1;
			for (int i = 0; i < padre1.getDescendientes().size(); i++) {
				if (n1 == padre1.getDescendientes().get(i)) {
					indice1 = i;
				}
			}
			//indice1 = padre1.getDescendientes().indexOf(n1);
			for (int i = 0; i < padre2.getDescendientes().size(); i++) {
				if (n2 == padre2.getDescendientes().get(i)) {
					indice2 = i;
				}
			}
//			System.out.println(indice1 + " " + indice2);
			
//			int indice1 = padre1.getDescendientes().indexOf(n1); int indice2 =
//			padre2.getDescendientes().indexOf(n2);
			
//			System.out.println(indice1 + " " + indice2);
			
//			System.out.println(padre1 + " " + padre2);
			
			INodo aux1 = n1.copy(); INodo aux2 = n2.copy(); aux1.setPadre(padre2);
			aux2.setPadre(padre1);
			
			padre1.getDescendientes().remove(indice1);
			padre1.getDescendientes().add(indice1, aux2.copy());
			
			padre2.getDescendientes().remove(indice2);
			padre2.getDescendientes().add(indice2, aux1.copy());
			 
			nuevo1.etiquetaNodos();
			nuevo2.etiquetaNodos();
			
			
//			padre1.getDescendientes().remove(n1);
//			padre2.getDescendientes().remove(n2);
//			padre1.getDescendientes().add(1, n2.copy());
//			padre2.getDescendientes().add(1, n1.copy());
			
//			System.out.println(padre1 + " " + padre2);

			List<IIndividuo> nuevos = new ArrayList<IIndividuo>();
			nuevos.add(nuevo1);
			nuevos.add(nuevo2);

			return nuevos;
		}
	}

}
