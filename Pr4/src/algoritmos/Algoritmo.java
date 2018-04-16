package algoritmos;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import excepciones.ArgsDistintosFuncionesException;
import excepciones.ArgumentosInvalidosAlgoritmo;
import excepciones.CruceNuloException;
import funciones.Funcion;
import individuos.Individuo;
import interfaces.*;
import terminales.Terminal;

public class Algoritmo implements IAlgoritmo {
	
	private List<IIndividuo> poblacion;
	private int n_iteraciones = 0;
	private List<Terminal> conjuntoTerminales;
	private List<Funcion> conjuntoFunciones;
	private int profundidadMaximaInicial;
	private int numeroIndividuos;
	private int probabilidadCruce;
	private int numeroMaximoGeneraciones;
	private int k;
	
	public Algoritmo(int profundidadMaximaInicial, int numeroIndividuos, int probabilidadCruce,
			int numeroMaximoGeneraciones, int k) throws ArgumentosInvalidosAlgoritmo {
		if (profundidadMaximaInicial <= 0 || numeroIndividuos <= 0 || probabilidadCruce < 0 || probabilidadCruce > 1
				|| numeroMaximoGeneraciones <= 0 || k < numeroIndividuos) {
			throw new ArgumentosInvalidosAlgoritmo();
		}
		this.profundidadMaximaInicial = profundidadMaximaInicial;
		this.numeroIndividuos = numeroIndividuos;
		this.probabilidadCruce = probabilidadCruce;
		this.numeroMaximoGeneraciones = numeroMaximoGeneraciones;
		this.k = k;
	}

	@Override
	public void defineConjuntoTerminales(List<Terminal> terminales) {
		this.conjuntoTerminales = terminales;
	}

	@Override
	public void defineConjuntoFunciones(List<Funcion> funciones) throws ArgsDistintosFuncionesException {
		this.conjuntoFunciones = funciones;
		
		
		// TODO por qué esta funcion lanza esa excepcion cuando es un setter?
	}

	@Override
	public void crearPoblacion() {
		// El método crearPoblación crea la población aleatoria inicial.
		this.poblacion = new ArrayList<IIndividuo>();
		
		for (int i = 0; i < this.numeroIndividuos; i++) {
			Individuo nuevo = new Individuo();
			
			nuevo.crearIndividuoAleatorio(this.profundidadMaximaInicial, this.conjuntoTerminales, this.conjuntoFunciones);
			
			this.poblacion.add(nuevo);
		}
	}

	@Override
	public List<IIndividuo> cruce(IIndividuo prog1, IIndividuo prog2) throws CruceNuloException {
		int randomNum1 = ThreadLocalRandom.current().nextInt(0, prog1.getNumeroNodos());
		int randomNum2 = ThreadLocalRandom.current().nextInt(0, prog2.getNumeroNodos());

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
						
			INodo aux1 = n1.copy(); INodo aux2 = n2.copy();
			aux1.setPadre(padre2); aux2.setPadre(null);
			
			nuevo1.setExpresion(aux2);
			
			padre2.getDescendientes().remove(indice2);
			padre2.getDescendientes().add(indice2, aux1.copy());
			 
			nuevo1.etiquetaNodos();
			nuevo2.etiquetaNodos();
			
			
			List<IIndividuo> nuevos = new ArrayList<>();
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
						
			INodo aux1 = n1.copy(); INodo aux2 = n2.copy();
			aux1.setPadre(null); aux2.setPadre(padre1);
			
			nuevo2.setExpresion(aux1);
			
			padre1.getDescendientes().remove(indice1);
			padre1.getDescendientes().add(indice1, aux2.copy());
			 
			nuevo1.etiquetaNodos();
			nuevo2.etiquetaNodos();
			
			
			List<IIndividuo> nuevos = new ArrayList<>();
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

			INodo padre1 = n1.getPadre();
			INodo padre2 = n2.getPadre();
			
			int indice1 = -1, indice2 = -1;
			for (int i = 0; i < padre1.getDescendientes().size(); i++) {
				if (n1 == padre1.getDescendientes().get(i)) {
					indice1 = i;
				}
			}
			for (int i = 0; i < padre2.getDescendientes().size(); i++) {
				if (n2 == padre2.getDescendientes().get(i)) {
					indice2 = i;
				}
			}
			
//			int indice1 = padre1.getDescendientes().indexOf(n1);
//			int indice2 = padre2.getDescendientes().indexOf(n2);
						
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
			
			List<IIndividuo> nuevos = new ArrayList<IIndividuo>();
			nuevos.add(nuevo1);
			nuevos.add(nuevo2);

			return nuevos;
		}
	}

	@Override
	public void crearNuevaPoblacion() {
		// TODO Auto-generated method stub
		
		// El método crearNuevaPoblacion crea una nueva población a partir de una
		// población anterior, aplicando el operador de cruce y el paso directo de
		// individuos no cruzados o elitistas

	}

	@Override
	public void ejecutar(IDominio dominio) {
		// TODO Auto-generated method stub
		
		// el método ejecutar equivale a un main para el algoritmo de programación
		// genética e implementa el pseudocódigo comentado anteriormente. Cuando se crea
		// un Algoritmo de Programación Genética se deben especificar algunos
		// parámetros, como la profundidad máxima de los individuos en la población
		// inicial, el número de individuos de la población, la probabilidad de cruce,
		// el número máximo de generaciones y el valor de K par los torneos.

		// La ejecución de los algoritmos de programación genética suele ser costosa en
		// tiempo y recursos. Como información durante la ejecución basta con que
		// muestres el número de generación, el mejor individuo encontrado en esa
		// generación y el fitness de dicho individuo.
	}

}
