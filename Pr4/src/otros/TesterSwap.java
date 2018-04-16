package otros;

import java.util.*;

import funciones.*;
import individuos.Individuo;
import interfaces.IIndividuo;
import terminales.Terminal;
import terminales.TerminalAritmetico;

public class TesterSwap {

	public static void main(String[] args) {
		IIndividuo i = new Individuo();
		List<Terminal> t = new ArrayList<Terminal>();
		List<Funcion> f = new ArrayList<Funcion>();
		t.add(new TerminalAritmetico("x"));
		f.add(new FuncionMultiplicacion("*", 6));
		f.add(new FuncionSuma("+", 5));
		i.crearIndividuoAleatorio(3, t, f);
		i.writeIndividuo();
	}
}