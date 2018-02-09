import java.util.*; //importamos todas las clases del paquete java.util

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
	private Map<Integer, Long> cache = new HashMap<>();


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
	*
	*/
	private int posicion(int n, int k) {
		int pos;

		pos = n*(n+1)/2 + k;

		return pos;
	}


	/*
	* Genera la cadena de caracteres que al ser imprimida genera el triángulo
	*/
	public String toString() {
		int i;
		int j;
		long valor;
		String str = "";

		for (i = 0; i < n; i++) {
			for (j = 0; j <= i; j++) {

				if (cache.containsKey(posicion(i, j))) {	// Si ya está calculado el valor lo concatenamos ...
					str += cache.get(posicion(i, j)) + " ";	
				} else {									//... si no calculamos el valor y lo guardamos en todas las posiciones útiles
					valor = (Long) c.combinaciones(i, j);
					cache.put(posicion(i, j), valor);
					cache.put(posicion(i, i - j), valor);

					str += valor + " ";
				}
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