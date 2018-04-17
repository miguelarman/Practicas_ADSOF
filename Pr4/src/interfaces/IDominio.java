package interfaces;

import java.io.*;
import java.util.List;

import excepciones.*;
import funciones.Funcion;
import terminales.Terminal;

/**
 * Interfaz que describe los metodos necesarios para describir un dominio
 * 
 * @author Miguel Arconada (miguel.arconada@estudiante.uam.es) Alberto Gonzalez (alberto.gonzalezk@estudiante.uam.es)
 */
public interface IDominio {
	/**
	 * Este metodo devuelve la lista de terminales que se pueden utilizar para generar individuos aleatorios para evaluar con este dominio
	 * 
	 * @param terminales Simbolos que definen los terminales
	 * 
	 * @return Lista de terminales
	 */
	public List<Terminal> definirConjuntoTerminales(String... terminales);

	/**
	 * Este metodo devuelve la lista de funciones que se pueden utilizar para generar individuos aleatorios para evaluar con este dominio
	 * 
	 * @param funciones Simbolos que definen las funciones
	 * @param argumentos Lista de enteros que describe el numero de hijos de cada funcion
	 * 
	 * @throws ArgsDistintosFuncionesException Cuando la cantidad de funciones y argumentos es diferentes 
	 * @throws SimboloFuncionInvalido Cuando un simbolo que describe funcion no se relaciona con ninguna funcion implementada
	 *  
	 * @return Lista de funciones
	 */
	public List<Funcion> definirConjuntoFunciones(int[] argumentos, String... funciones)
			throws ArgsDistintosFuncionesException, SimboloFuncionInvalido;

	/**
	 * Metodo que define el fichero del que leer los valores con los que evaluar los individuos
	 * 
	 * @param ficheroDatos Ruta del fichero con los datos
	 * 
	 * @throws FileNotFoundException Cuando no se encuentra el fichero
	 * @throws IOException Excepcion propia de Java cuando encuentra un error
	 */
	public void definirValoresPrueba(String ficheroDatos) throws FileNotFoundException, IOException;

	/**
	 * Metodo que calcula el fitness de un individuo, usando los valores cargados
	 * mediante el metodo definirValoresPrueba. Se usa un threshold para evaluar los
	 * puntos en los que se acerca la funcion
	 * 
	 * @param individuo Individuo que se desea evaluar
	 * 
	 * @return Fitness del individuo
	 */
	public double calcularFitness(IIndividuo individuo);
}