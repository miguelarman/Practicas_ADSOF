package interfaces;

import java.util.HashMap;
import java.util.List;

import funciones.Funcion;
import terminales.Terminal;

public interface INodo {
	
	public String getRaiz();

	public List<INodo> getDescendientes();

	public void incluirDescendiente(INodo nodo);

	public double calcular();

	public INodo copy();

	public int etiquetaNodoRecursivo(HashMap<Integer, INodo> etiquetas, int i);
	
	public void crearNodoAleatorioRecursivo(int profundidad, List<Terminal> terminales, List<Funcion> funciones);
	
	public int contarHijos();
	
	public INodo getPadre();

	public void setPadre(INodo nodo);
	
	public void actualizarPadres();


}
