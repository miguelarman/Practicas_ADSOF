package funciones;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import interfaces.INodo;
import terminales.Terminal;

/**
 * Clase que implementa los nodos que no son hojas, que tienen descendientes,
 * por lo que sus valores dependen de los valores de sus hijos y de una funcion
 * aritmetica
 * 
 * @author Miguel Arconada (miguel.arconada@estudiante.uam.es) Alberto Gonzalez (alberto.gonzalezk@estudiante.uam.es)
 */
public abstract class Funcion implements INodo, Cloneable {
	
	/**
	 * Raiz de la funcion. Simboliza el simbolo de la operacion (*, +, -), usado al imprimirlo
	 */
	private String raiz;
	
	/**
	 * Lista de descendientes de la funcion
	 */
	private List<INodo> descendientes;
	
	/**
	 * Numero maximo de descendientes que puede manejar la funcion
	 */
	protected Integer maximosDescendientes;
	
	/**
	 * Nodo padre de este nodo funcion
	 */
	private INodo padre;
	
	/**
	 * Constructor de la clase Funcion
	 * 
	 * @param raiz Simbolo que representa la funcion
	 * @param maximosDescendientes Numero maximo de descendientes del nodo
	 */
	public Funcion(String raiz, Integer maximosDescendientes) {
		this.raiz = raiz;
		this.descendientes = new ArrayList<INodo>();
		this.maximosDescendientes = maximosDescendientes;
		this.padre = null;
	}

	@Override
	public String getRaiz() {
		return this.raiz;
	}

	@Override
	public List<INodo> getDescendientes() {
		return this.descendientes;
	}

	@Override
	public void incluirDescendiente(INodo nodo) {
		if (this.descendientes.size() < this.maximosDescendientes) {
			this.descendientes.add(nodo);
			
			this.descendientes.get(this.descendientes.size() - 1).setPadre(this);
		}
	}

	@Override
	public abstract double calcular();

	@Override
	public abstract INodo copy();
	
	@Override
	public int etiquetaNodoRecursivo(HashMap<Integer, INodo> etiquetas, int i) {		
		etiquetas.put(i, this);
		i++;
		
		for (INodo nodo : this.getDescendientes()) {
			i = nodo.etiquetaNodoRecursivo(etiquetas, i);
		}
		
		return i;
	}
	
	public int contarHijos() {
		int numHijos = 0;
		for(INodo n : descendientes) {
			numHijos += n.contarHijos();
			numHijos++;
		}
		return numHijos;
	}
	
	@Override
	public void crearNodoAleatorioRecursivo(int profundidad, List<Terminal> terminales, List<Funcion> funciones) {
		int randomNum = ThreadLocalRandom.current().nextInt(2, this.maximosDescendientes + 1);
		if(profundidad == 0) {
			for(int i = 0; i < randomNum; i++) {
				int randomNum2 = ThreadLocalRandom.current().nextInt(0, terminales.size());
				this.incluirDescendiente(terminales.get(randomNum2).copy());
			}
		}
		else {
			for(int i = 0; i < randomNum; i++) {
				int randomNum2 = ThreadLocalRandom.current().nextInt(0, funciones.size());
				this.incluirDescendiente(funciones.get(randomNum2).copy());
				this.getDescendientes().get(i).crearNodoAleatorioRecursivo(profundidad - 1, terminales, funciones);
			}
		}
		
	}
	
	@Override
	public String toString() {
		String string = "";
		
		string += "( " + this.getRaiz();
		
		for (INodo n : this.getDescendientes()) {
			string += " " + n;
		}
		
		string += " )";
		
		return string;
	}
	
	@Override
	public INodo getPadre() {
		return this.padre;
	}
	
	@Override
	public void setPadre(INodo nodo) {
		this.padre = nodo;
	}
	
	@Override
	public abstract boolean equals(Object o);
	
	@Override
	public void actualizarPadres() {
		for (INodo hijo : this.getDescendientes()) {
			hijo.setPadre(this);
			hijo.actualizarPadres();
		}
	}
}
