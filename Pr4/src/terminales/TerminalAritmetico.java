package terminales;

import interfaces.INodo;

public class TerminalAritmetico extends Terminal {
	
	private static Integer valor;

	public TerminalAritmetico(String raiz) {
		super(raiz);
		// TODO Auto-generated constructor stub
	}

	@Override
	public INodo copy() {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public int contarHijos() {
		return 0;
	}
}
