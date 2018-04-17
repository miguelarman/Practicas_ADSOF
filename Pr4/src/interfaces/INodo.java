package interfaces;

import java.util.*;

import funciones.Funcion;
import terminales.Terminal;

/**
 * Interfaz que engloba todos los metodos necesarios para crear una clase que represente un nodo de un arbol
 * 
 * @author Miguel Arconada (miguel.arconada@estudiante.uam.es) Alberto Gonzalez (alberto.gonzalezk@estudiante.uam.es)
 *
 */
public interface INodo {
	
	/**
	 * Metodo getter para el atributo raiz del nodo
	 * 
	 * @return Raiz del nodo
	 */
	public String getRaiz();
	
	/**
	 * Metodo getter para la lista de nodos descendientes del nodo en el que se llama
	 * 
	 * @return Lista de descendientes del nodo
	 */
	public List<INodo> getDescendientes();

	/**
	 * Metodo para incluir un nodo como descendiente
	 * 
	 * @param nodo Nodo a incluir en la lista de descendientes
	 */
	public void incluirDescendiente(INodo nodo);

	/**
	 * Metodo que calcula el valor de un nodo, dependiente del valor de sus
	 * descendientes. Dependiendo del tipo de nodo que sea (Terminal, Funcion...)
	 * devuelve un valor prefijado o una combinacion de los valores de sus
	 * descendientes
	 * 
	 * @return Valor obtenido al calcular
	 */
	public double calcular();

	/**
	 * Metodo que devuelve una copia del nodo en el que se llama. Depende del tipo
	 * de nodo que sea, y es una funcion recursiva, al tener que copiar los nodos
	 * descendientes
	 * 
	 * @return Copia del nodo
	 */
	public INodo copy();

	/**
	 * Metodo usado en el algoritmo genetico para etiquetar los nodos de un
	 * individuo de forma biyectiva. Se usa la busqueda por profundidad (DFS)
	 * 
	 * @param etiquetas HashMap en el que insertar las duplas
	 * @param i Siguiente etiqueta en la que etiquetar al nodo
	 * 
	 * @return Siguiente etiqueta disponible despues de etiquetar el nodo y todos sus descendientes
	 */
	public int etiquetaNodoRecursivo(HashMap<Integer, INodo> etiquetas, int i);
	
	/**
	 * Metodo usado para generar un individuo aleatorio. Es recursivo, puesto que
	 * todos sus descendientes tienen que ser subarboles aleatorios
	 * 
	 * @param profundidad Profundidad desdeada para ese arbol
	 * @param terminales Lista de terminales entre los que escoger para crear los nodos
	 * @param funciones Lista de funciones disponibles para el individuo
	 */
	public void crearNodoAleatorioRecursivo(int profundidad, List<Terminal> terminales, List<Funcion> funciones);
	
	/**
	 * Metodo que devuelve el numero de descendientes totales de un nodo, tanto los
	 * directos como los descendientes de sus descendientes
	 * 
	 * @return Numero de descendientes de un nodo
	 */
	public int contarHijos();
	
	/**
	 * Metodo getter para el campo padre de un nodo
	 * 
	 * @return Devuelve el padre de un nodo, o null si es un nodo raiz
	 */
	public INodo getPadre();

	/**
	 * Metodo setter para el campo padre de un nodo
	 * 
	 * @param nodo Nuevo padre del nodo
	 */
	public void setPadre(INodo nodo);
	
	/**
	 * Funcion recursiva utilizada para asegurarse de que los punteros estan apuntando a un padre correcto. Es recursiva
	 */
	public void actualizarPadres();


}
