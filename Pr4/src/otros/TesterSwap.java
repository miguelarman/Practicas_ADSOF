package otros;

import java.io.FileNotFoundException;
import java.io.IOException;

import algoritmos.Algoritmo;
import dominios.DominioAritmetico;
import excepciones.ArgumentosInvalidosAlgoritmo;
import interfaces.IDominio;

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
		
		DominioAritmetico.setMargen(1.0);
//		DominioAritmetico.setMargen(0.5);
		
		try {
			Algoritmo alg = new Algoritmo(5, 150, 0.9, 10000, 6);
			alg.ejecutar(d);
		} catch (ArgumentosInvalidosAlgoritmo e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}