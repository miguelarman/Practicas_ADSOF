package interfaces;

import java.util.List;

import funciones.Funcion;
import terminales.Terminal;

public interface IIndividuo {
	public INodo getExpresion();

	public void setExpresion(INodo expresion);

	public double getFitness();

	public void setFitness(double fitness);

	public void crearIndividuoAleatorio(int profundidad, List<Terminal> terminales, List<Funcion> funciones);

	public double calcularExpresion();

	public int getNumeroNodos();

	public void writeIndividuo();
}