package individuos;

import java.util.HashMap;
import java.util.List;

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
		// TODO Auto-generated method stub
		
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
		nuevo.etiquetas = new HashMap<>();
		for (Integer i : this.etiquetas.keySet()) {
			nuevo.etiquetas.put(i, this.etiquetas.get(i).copy());
		}
		
		return nuevo;
	}
}
