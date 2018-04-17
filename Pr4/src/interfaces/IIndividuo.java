package interfaces;

import java.util.HashMap;
import java.util.List;

import funciones.Funcion;
import terminales.Terminal;

/**
 * Interfaz que describe los elementos necesarios para describir un individuo
 * 
 * @author Miguel Arconada (miguel.arconada@estudiante.uam.es) Alberto Gonzalez (alberto.gonzalezk@estudiante.uam.es)
 */
public interface IIndividuo {
	/**
	 * Metodo getter para el campo expresion del individuo (nodo raiz)
	 * 
	 * @return Campo expresion del individuo
	 */
	public INodo getExpresion();

	/**
	 * Metodo setter para el campo expresion (nodo raiz) del individuo
	 * 
	 * @param expresion Nodo raiz
	 */
	public void setExpresion(INodo expresion);

	/**
	 * Metodo getter para el atributo fitness del individuo
	 * 
	 * @return Fitness del individuo. Es inicializado mediante un dominio
	 */
	public double getFitness();

	/**
	 * Metodo setter para el campo fitness del individuo
	 * 
	 * @param fitness Fitness del individuo. Deberia ser calculado mediante un Dominio
	 */
	public void setFitness(double fitness);
	
	/**
	 * Metodo getter para el campo etiquetas del individuo. Es utilizado en el
	 * algoritmo genetico para seleccionar que nodos cruzar
	 * 
	 * @return HashMap con las etiquetas del individuo
	 */
	public HashMap<Integer, INodo> getEtiquetas();

	/**
	 * Metodo que inicializa el campo expresion del individuo (su nodo raiz) a un
	 * individuo generado aleatoriamente
	 * 
	 * @param profundidad
	 *            Profundidad deseada
	 * @param terminales
	 *            Lista de terminales entre los que escoger
	 * @param funciones
	 *            Lista de funciones entre los que escoge la funcion
	 */
	public void crearIndividuoAleatorio(int profundidad, List<Terminal> terminales, List<Funcion> funciones);

	/**
	 * Metodo que calcula el valor numerico de un individuo, mediante llamadas a la
	 * funcion recursiva de nodo
	 * 
	 * @return Valor calculado
	 */
	public double calcularExpresion();

	/**
	 * Metodo que calcula el numero total de nodos en el individuo. Es recursiva
	 * 
	 * @return Numero de nodos
	 */
	public int getNumeroNodos();

	/**
	 * Metodo que imprime por pantalla la expresion del individuo. Se usa la
	 * notacion prefija
	 */
	public void writeIndividuo();

	/**
	 * Metodo que etiqueta los nodos del individuo de forma biyectiva. Se usa en el
	 * algoritmo genetico
	 */
	public void etiquetaNodos();

	/**
	 * Metodo que crea una copia del individuo campo por campo
	 * 
	 * @return Copia del individuo
	 */
	public IIndividuo copy();
}
