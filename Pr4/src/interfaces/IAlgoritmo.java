package interfaces;

import java.util.List;

import excepciones.*;
import funciones.*;
import terminales.*;

/**
 * Interfaz que describe las funciones necesarias en cualquier clase que
 * implemente el algoritmo genetico
 * 
 * @author Miguel Arconada (miguel.arconada@estudiante.uam.es) Alberto Gonzalez (alberto.gonzalezk@estudiante.uam.es)
 */
public interface IAlgoritmo {
	
	/**
	 * Metodo que define el conjunto de terminales para generar los individuos aleatorios
	 * 
	 * @param terminales Terminales que queremos utilizar
	 */
	public void defineConjuntoTerminales(List<Terminal> terminales);

	/**
	 * Metodo que define el conjunto de funciones disponibles para crear individuos aleatorios
	 * 
	 * @param funciones Funciones disponibles
	 * @throws ArgsDistintosFuncionesException cuando la funcion de IDominio lanza esta excepcion
	 */
	public void defineConjuntoFunciones(List<Funcion> funciones) throws ArgsDistintosFuncionesException;

	/**
	 * Metodo que genera una poblacion aleatoria de individuos para empezar el algoritmo genetico
	 */
	public void crearPoblacion();

	/**
	 * Metodo que cruza dos individuos de forma aleatoria. Escoge un nodo aleatorio
	 * de cada individuo y los intercambia
	 * 
	 * @param prog1 Primer individuo a cruzar
	 * @param prog2 Segundo individuo a cruzar
	 * 
	 * @throws CruceNuloException Cuando en los dos individuos se escoge como nodo de cruce la raiz
	 * 
	 * @return Lista con los dos individuos generados por el cruce
	 */
	public List<IIndividuo> cruce(IIndividuo prog1, IIndividuo prog2) throws CruceNuloException;

	/**
	 * Metodo que toma la poblacion almacenada en el algoritmo y mediante el
	 * algoritmo la modifica, siguiendo unos pasos (torneos, elitismo...)
	 */
	public void crearNuevaPoblacion();

	/**
	 * Funcion que ejecuta el algoritmo. Toma una poblacion aleatoria inicial e
	 * itera los pasos hasta encontrar un individuo ideal o agotar un numero de
	 * iteraciones
	 * 
	 * @param dominio Dominio con el que evaluar los individuos
	 */
	public void ejecutar(IDominio dominio);
}