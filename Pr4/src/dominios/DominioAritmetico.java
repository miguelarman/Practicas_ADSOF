package dominios;

import java.io.*;
import java.util.*;

import excepciones.ArgsDistintosFuncionesException;
import excepciones.SimboloFuncionInvalido;
import funciones.*;
import interfaces.*;
import terminales.Terminal;
import terminales.TerminalAritmetico;

public class DominioAritmetico implements IDominio {
	
	private static double margen = 1.0;
	private HashMap<Integer, Integer> valoresPrueba;

	@Override
	public List<Terminal> definirConjuntoTerminales(String... terminales) {
		List<Terminal> terminal = new ArrayList<Terminal>();
		
		for (int i = 0; i < terminales.length; i++) {
			if (terminales[i].compareTo("x") == 0) {
				terminal.add(new TerminalAritmetico(terminales[i]));
			}
		}
		
		return terminal;
	}
	
	@Override
	public List<Funcion> definirConjuntoFunciones(int[] argumentos, String... funciones)
			throws ArgsDistintosFuncionesException, SimboloFuncionInvalido {
		
		if (argumentos.length != funciones.length) {
			throw new ArgsDistintosFuncionesException();
		}
		
		List<Funcion> lista = new ArrayList<Funcion>();
		
		for (int i = 0; i < argumentos.length; i++) {
			switch(funciones[i]) {
				case "+":
		             lista.add(new FuncionSuma(funciones[i], argumentos[i]));
		             break;
				case "-":
					 lista.add(new FuncionResta(funciones[i], argumentos[i]));
		             break;
				case "*":
					 lista.add(new FuncionMultiplicacion(funciones[i], argumentos[i]));
		             break;
		        default:
		        	throw new SimboloFuncionInvalido(funciones[i]);
			}
		}
		
		return lista;
	}

	@Override
	public void definirValoresPrueba(String ficheroDatos) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("valores.txt")));
		
		this.valoresPrueba = new HashMap<Integer, Integer>();
		
		for(String x = br.readLine(); x != null; x = br.readLine()) {
			StringTokenizer str = new StringTokenizer(x, "\t");
			String[] info = new String[str.countTokens()];
			
			for(int i = 0; i < info.length; i++) {
				info[i] = str.nextToken();
			}
			
			this.valoresPrueba.put(Integer.parseInt(info[0]), Integer.parseInt(info[1]));
		}
		
		br.close();
	}
	
	@Override
	public double calcularFitness(IIndividuo individuo) {
		double fitness = 0.0;
		
		for (Integer valor : this.valoresPrueba.keySet()) {
			TerminalAritmetico.setValor(valor);
			
			double resultado = individuo.calcularExpresion();
			double valorEsperado = this.valoresPrueba.get(valor);
			
			if (Math.abs(resultado - valorEsperado) <= DominioAritmetico.margen ) {
				fitness ++;
			}
			
			//System.out.println("Valor " + valor + " <-> Rdo estimado: " + resultado + " <-> Rdo real: " + valorEsperado);
		}
		
		individuo.setFitness(fitness);
		
		return fitness;
	}

}
