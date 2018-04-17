package algoritmos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import excepciones.ArgsDistintosFuncionesException;
import excepciones.ArgumentosInvalidosAlgoritmo;
import excepciones.CruceNuloException;
import excepciones.SimboloFuncionInvalido;
import funciones.Funcion;
import individuos.Individuo;
import interfaces.*;
import terminales.Terminal;

public class Algoritmo implements IAlgoritmo {
	
	private List<IIndividuo> poblacion;
	private List<Terminal> conjuntoTerminales;
	private List<Funcion> conjuntoFunciones;
	private int profundidadMaximaInicial;
	private int numeroIndividuos;
	private double probabilidadCruce;
	private int numeroMaximoGeneraciones;
	private int k;
	private IDominio dominio;
	Comparator<IIndividuo> comparator = new OrganizadorPorFitness();
	
	public Algoritmo(int profundidadMaximaInicial, int numeroIndividuos, double probabilidadCruce,
			int numeroMaximoGeneraciones, int k) throws ArgumentosInvalidosAlgoritmo {
		if (profundidadMaximaInicial <= 0) {
			throw new ArgumentosInvalidosAlgoritmo("Argumento profundidadMaximaInicial invalido");
		} else if (numeroIndividuos <= 0) {
			throw new ArgumentosInvalidosAlgoritmo("Argumento numeroIndividuos invalido");
		} else if (probabilidadCruce < 0.0 || probabilidadCruce > 1.0) {
			throw new ArgumentosInvalidosAlgoritmo("Argumento probabilidadCruce invalido");
		} else if (numeroMaximoGeneraciones <= 0) {
			throw new ArgumentosInvalidosAlgoritmo("Argumento numeroMaximoGeneraciones invalido");
		} else if (k > numeroIndividuos) {
			throw new ArgumentosInvalidosAlgoritmo("Argumento k invalido");
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
			IIndividuo nuevo = new Individuo();
			
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
						
			INodo aux1 = n1.copy(); INodo aux2 = n2.copy();
			aux1.setPadre(padre2); aux2.setPadre(padre1);
			
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

		List<IIndividuo> nuevaPoblacion = new ArrayList<IIndividuo>();
		List<IIndividuo> individuosACruzar = new ArrayList<IIndividuo>();
		List<IIndividuo> individuosSinCruzar = new ArrayList<IIndividuo>();
				
		for (IIndividuo i : this.poblacion) {
			this.dominio.calcularFitness(i);
		}
		
		// Conservamos el mejor individuo
		Collections.shuffle(this.poblacion);
		this.poblacion.sort(comparator);
		individuosSinCruzar.add(this.poblacion.get(0).copy());
		this.poblacion.remove(0);
		
		
		Collections.shuffle(this.poblacion);
		
		for (IIndividuo individuo : this.poblacion) {
			float aleatorio = (float) ThreadLocalRandom.current().nextDouble(0, 1);
			
			if (aleatorio < this.probabilidadCruce) {
				individuosACruzar.add(individuo.copy());
			} else {
				individuosSinCruzar.add(individuo.copy());
			}
		}
		
		// Generamos grupos de k individuos para cruzar
		while(individuosACruzar.size() >= k) {
			List<IIndividuo> grupo = new ArrayList<IIndividuo>();
			
			Collections.shuffle(individuosACruzar);
			
			for (int i = 0; i < this.k; i++) {
				int indiceAleatorio = ThreadLocalRandom.current().nextInt(0, individuosACruzar.size());
				grupo.add(individuosACruzar.get(indiceAleatorio));
				individuosACruzar.remove(indiceAleatorio);
			}
			
			// Elimina estos elementos
//			for (int i = 0; i < grupo.size(); i++) {
//				individuosACruzar.remove(0);
//			}
//			individuosACruzar.removeAll(grupo);
			
			// Ordenamos el grupo segun el fitness
			grupo.sort(comparator);
			
			// Cruce de los dos mejores
			List<IIndividuo> nodosCruzados;
			
			try {
				nodosCruzados = this.cruce(grupo.get(0).copy(), grupo.get(1).copy());
				// Elimino los dos peores
				grupo.remove(grupo.size()- 1); grupo.remove(grupo.size()-1);
				
				// Calculo el nuevo fitness
				this.dominio.calcularFitness(nodosCruzados.get(0));
				this.dominio.calcularFitness(nodosCruzados.get(1));
				
				// Anado los nuevos elementos al grupo
				grupo.addAll(nodosCruzados);
			} catch (CruceNuloException e) {
				
			}
			
			// Anado los elementos del grupo a la nueva poblacion
			nuevaPoblacion.addAll(grupo);
			
		}
		
		// Los elementos restantes (que no llegan a k) se pasan directamente
		nuevaPoblacion.addAll(individuosACruzar);
		
		// Anadimos los elementos que no hemos cruzado
		nuevaPoblacion.addAll(individuosSinCruzar);
		
		// Vuelvo a calcular el fitness
		for (IIndividuo i : nuevaPoblacion) {
			this.dominio.calcularFitness(i);
		}
		
		
		this.poblacion = nuevaPoblacion;
	}

	@Override
	public void ejecutar(IDominio dominio) {
		
		int generacion = 1;
		this.dominio = dominio;
		
		this.conjuntoTerminales = dominio.definirConjuntoTerminales("x");
		int numeros[] = {2, 2, 2};
		String funciones[] = {"+", "-", "*"};
		try {
			this.conjuntoFunciones = dominio.definirConjuntoFunciones(numeros, funciones);
		} catch (ArgsDistintosFuncionesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SimboloFuncionInvalido e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.crearPoblacion();
		for(int i= 0; i < this.poblacion.size(); i++) {
			dominio.calcularFitness(poblacion.get(i));
		}
		this.poblacion.sort(comparator);
		
		System.out.println("Generacion: " + generacion + "\nMejor Individuo: ");
		this.poblacion.get(0).writeIndividuo(); 
		System.out.println("\nFitness: " + this.poblacion.get(0).getFitness());
		
		if(this.poblacion.get(0).getFitness() >= 20.0) {
			System.out.println("El algoritmo va a acabar");
			return;
		}
		
		// DEBUGGING
//		for (IIndividuo i : this.poblacion) {
//			i.writeIndividuo();
//			System.out.print(i.getFitness());
//		}
		
		for (int j = 0; j < this.numeroMaximoGeneraciones; j++) {
			generacion++;
			this.crearNuevaPoblacion();
			for(int i= 0; i < this.poblacion.size(); i++) {
				dominio.calcularFitness(poblacion.get(i));
			}
			this.poblacion.sort(comparator);
			
			 //if (generacion % 50 == 0) {
				System.out.println();
				System.out.println("Generacion: " + generacion + "\nMejor Individuo: ");
				this.poblacion.get(0).writeIndividuo(); 
				System.out.println("\nFitness: " + this.poblacion.get(0).getFitness());
			// }
			
			if(this.poblacion.get(0).getFitness() >= 21.0) {
				System.out.println("El algoritmo va a acabar porque se ha encontrado una solución óptima");
				break;
			}
			
			// DEBUGGING
//			for (IIndividuo i : this.poblacion) {
//				i.writeIndividuo();
//				System.out.print(i.getFitness());
//			}

		}
		
		
		System.out.println();System.out.println();System.out.println();
		System.out.println("INDIVIDUO FINAL");
		System.out.println("Generacion: " + generacion + "\nMejor Individuo: ");
		this.poblacion.get(0).writeIndividuo(); 
		System.out.println("\nFitness: " + this.poblacion.get(0).getFitness());
		
		
		// DEBUGGING
//		for (IIndividuo i : this.poblacion) {
//			i.writeIndividuo();
//			System.out.print(i.getFitness());
//		}
	}

}
