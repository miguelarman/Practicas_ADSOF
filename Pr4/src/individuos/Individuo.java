package individuos;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import funciones.Funcion;
import interfaces.IIndividuo;
import interfaces.INodo;
import terminales.Terminal;

public class Individuo implements IIndividuo {
	
	private INodo expresion;
	private double fitness;
	private HashMap<Integer, INodo> etiquetas;

	@Override
	public INodo getExpresion() {
		return this.expresion;
	}

	@Override
	public void setExpresion(INodo expresion) {
		this.expresion = expresion;
	}

	@Override
	public double getFitness() {
		return this.fitness;
	}

	@Override
	public void setFitness(double fitness) {
		this.fitness = fitness;
	}
	
	@Override
	public HashMap<Integer, INodo> getEtiquetas(){
		return this.etiquetas;
	}
	@Override
	public void crearIndividuoAleatorio(int profundidad, List<Terminal> terminales, List<Funcion> funciones) {
		this.etiquetas = new HashMap<Integer, INodo>();
		
		if(profundidad == 0) {
			int randomNum = ThreadLocalRandom.current().nextInt(0, terminales.size());
			expresion = terminales.get(randomNum).copy();
		}
		else {
			int randomNum = ThreadLocalRandom.current().nextInt(0, funciones.size());
			expresion = funciones.get(randomNum).copy();
			expresion.crearNodoAleatorioRecursivo(profundidad - 1, terminales, funciones);
		}
		
		
	}

	@Override
	public double calcularExpresion() {
		return this.expresion.calcular();
	}

	@Override
	public int getNumeroNodos() {
		int numNodos = expresion.contarHijos() + 1;
		return numNodos;
	}
	
	@Override
	public void etiquetaNodos() {
		this.etiquetas = new HashMap<Integer, INodo>();
		int i = 0;
		
		i = this.expresion.etiquetaNodoRecursivo(this.etiquetas, i);
	}

	@Override
	public void writeIndividuo() {
		System.out.println("Expresión: " + this.getExpresion());
	}

	@Override
	public IIndividuo copy() {
		Individuo nuevo = new Individuo();
		
		nuevo.expresion = this.expresion.copy();
		nuevo.fitness = this.fitness;
		nuevo.etiquetas = new HashMap<Integer, INodo>();
		for (Integer i : this.etiquetas.keySet()) {
			nuevo.etiquetas.put(i, this.etiquetas.get(i).copy());
		}
		
		nuevo.getExpresion().actualizarPadres();
		
		return nuevo;
	}
	
	@Override
	public String toString() {
		return "" + this.getExpresion();
	}
}
