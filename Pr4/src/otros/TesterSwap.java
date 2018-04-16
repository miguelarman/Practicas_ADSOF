package otros;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import algoritmos.Algoritmo;
import dominios.DominioAritmetico;
import excepciones.ArgumentosInvalidosAlgoritmo;
import funciones.*;
import individuos.Individuo;
import interfaces.IDominio;
import interfaces.IIndividuo;
import terminales.Terminal;
import terminales.TerminalAritmetico;

public class TesterSwap {

	public static void main(String[] args) {

		IDominio d = new DominioAritmetico();
		try {
			d.definirValoresPrueba("valores.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Algoritmo alg = new Algoritmo(2, 20, 0.9, 50, 4);
			alg.ejecutar(d);
		} catch (ArgumentosInvalidosAlgoritmo e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}