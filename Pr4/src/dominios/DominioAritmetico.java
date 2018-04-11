package dominios;

import java.io.*;
import java.util.*;

import excepciones.ArgsDistintosFuncionesException;
import funciones.Funcion;
import interfaces.*;
import terminales.Terminal;
import terminales.TerminalAritmetico;

public class DominioAritmetico implements IDominio {
	
	private static double margen = 1.0;
	private HashMap<Integer, Integer> valoresPrueba;

	@Override
	public List<Terminal> definirConjuntoTerminales(String... terminales) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Funcion> definirConjuntoFunciones(int[] argumentos, String... funciones)
			throws ArgsDistintosFuncionesException {
		// TODO Auto-generated method stub
		return null;
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
			
			if (Math.abs(resultado - valorEsperado) < DominioAritmetico.margen ) {
				fitness ++;
			}
			
			System.out.println("Valor " + valor + " <-> Rdo estimado: " + resultado + " <-> Rdo real: " + valorEsperado);
		}
		
		individuo.setFitness(fitness);
		
		return fitness;
	}

}
