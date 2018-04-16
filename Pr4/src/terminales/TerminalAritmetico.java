package terminales;

import interfaces.INodo;

public class TerminalAritmetico extends Terminal {
	
	private static Integer valor;

	public TerminalAritmetico(String raiz) {
		super(raiz);
	}

	@Override
	public INodo copy() {
		TerminalAritmetico copy = new TerminalAritmetico(this.getRaiz());
		copy.setPadre(this.getPadre());
		copy.actualizarPadres();
		return copy;
	}
	
	public static void setValor(Integer i) {
		TerminalAritmetico.valor = i;
	}

	@Override
	public String toString() {
		return this.getRaiz();
	}

	@Override
	public double calcular() {
		return TerminalAritmetico.valor;
	}
}
