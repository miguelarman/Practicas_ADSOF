/*
* Esta aplicación crea el triángulo de Tartaglia de un número de filas pasado como argumento
* <p>Para calcularlo llama a las funciones de la clase Combinatoria</p>
* <p><b>Nota</b>: Esta implementación no es muy eficiente, al hacer muchos cálculos redundantes.
* Se aconseja usar valores pequeños de n y k, entre 0 y 30</p>
*
* @author Miguel Arconada (miguel.arconada@estudiante.uam.es) y Alberto González (alberto.gonzalezk@estudiante.uam.es)
*/


public class Tartaglia {

	/*
	* Argumentos internos de la clase Tartaglia: objeto de la clase Combinatoria y un entero n que
	* define el número de filas del triángulo
	*/
	
	private Combinatoria c;
	private int n;


	/**
	* Crea un objeto de la clase Tartaglia 
	* @param c objeto de la clase Combinatoria
	* @param n entero que define las filas del triángulo
	*/

	public Tartaglia (Combinatoria c, int n) {
		this.c = c;
		this.n = n;
	}


	/*
	* Genera la cadena de caracteres que al ser imprimida genera el triángulo
	*/
	public String toString() {
		int i;
		int j;
		String str = "";


		for (i = 0; i < n; i++) {
			for (j = 0; j <= i; j++) {
				str += c.combinaciones(i, j) + " ";
			}

			str += "\n";
		}

		return str;
	}



	/**
	* Función de ejecución de la función
	*
	* <p>Este método imprime el triángulo de Tartaglia de orden n, especificado como argumento</p>
	*
	* @param args Los argumentos de la línea de comando. Se esperan un número entero, como cadenas
	*/

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Se espera un número como parámetro, n.");
		} else {
			int n = Integer.parseInt(args[0]);

			Combinatoria c= new Combinatoria();
			System.out.println(new Tartaglia(c, n));
		}
	}
}