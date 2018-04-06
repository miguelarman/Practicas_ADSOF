package individuos;

import java.util.List;

import funciones.Funcion;
import interfaces.IIndividuo;
import interfaces.INodo;
import terminales.Terminal;

public class Individuo implements IIndividuo {
	
	private INodo expresion;

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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setFitness(double fitness) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void crearIndividuoAleatorio(int profundidad, List<Terminal> terminales, List<Funcion> funciones) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double calcularExpresion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumeroNodos() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeIndividuo() {
		System.out.println("Expresión: " + this.getExpresion());
	}

}
