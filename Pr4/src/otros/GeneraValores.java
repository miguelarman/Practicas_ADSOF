package otros;

import java.io.*;

public class GeneraValores {

	public static void main(String[] args) throws IOException {
		BufferedWriter br = new BufferedWriter(new FileWriter(new File("valores.txt")));
		
		for (int i = -10; i <= 10; i++) {
			int valor = (int)(Math.pow(i, 4) + Math.pow(i, 3) + Math.pow(i, 2) + i);
			br.write("" + i + "\t" + valor +"\n");
		}
		
		br.close();
	}

}
