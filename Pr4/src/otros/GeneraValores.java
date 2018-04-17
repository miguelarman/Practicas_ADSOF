package otros;

import java.io.*;

/**
 * Clase utilizada para crear el fichero de datos utilizado para evaluar a los
 * individuos en el algoritmo genetico
 * 
 * @author Miguel Arconada (miguel.arconada@estudiante.uam.es) Alberto Gonzalez
 *         (alberto.gonzalezk@estudiante.uam.es)
 */
public class GeneraValores {

	/**
	 * Metodo main que genera el fichero
	 * 
	 * @param args Argumentos no utilizados
	 * @throws IOException Cuando Java encuentra problemas con el fichero
	 */
	public static void main(String[] args) throws IOException {
		BufferedWriter br = new BufferedWriter(new FileWriter(new File("valores.txt")));
		
		for (int i = -10; i <= 10; i++) {
			int valor = (int)(Math.pow(i, 4) + Math.pow(i, 3) + Math.pow(i, 2) + i);
			br.write("" + i + "\t" + valor +"\n");
		}
		
		br.close();
	}

}
