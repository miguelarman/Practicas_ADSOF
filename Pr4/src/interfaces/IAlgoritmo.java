package interfaces;

import java.util.List;

import excepciones.*;
import funciones.*;
import terminales.*;

public interface IAlgoritmo {
	
	public void defineConjuntoTerminales(List<Terminal> terminales);

	public void defineConjuntoFunciones(List<Funcion> funciones) throws ArgsDistintosFuncionesException;

	public void crearPoblacion();

	public List<IIndividuo> cruce(IIndividuo prog1, IIndividuo prog2) throws CruceNuloException;

	public void crearNuevaPoblacion();

	public void ejecutar(IDominio dominio);
}