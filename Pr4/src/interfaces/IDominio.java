package interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import excepciones.*;
import funciones.Funcion;
import terminales.Terminal;

public interface IDominio {
	public List<Terminal> definirConjuntoTerminales(String... terminales);

	public List<Funcion> definirConjuntoFunciones(int[] argumentos, String... funciones)
			throws ArgsDistintosFuncionesException, SimboloFuncionInvalido;

	public void definirValoresPrueba(String ficheroDatos) throws FileNotFoundException, IOException;

	public double calcularFitness(IIndividuo individuo);
}