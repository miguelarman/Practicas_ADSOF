import java.util.*; 


/**
* Esta aplicación calcula el número de combinaciones sin repetición de n elementos
* tomados de k en k.
* <p>La implementación es recursiva, basada en c(n, k) = c(n-1, k-1) + c(n-1, k)
* Los casos base son c(n, 0) = 1 = c(n, n) y c(n, k) = 0 para todo k mayor que n</p>
* <p><b>Nota</b>: Esta implementación no es muy eficiente, al hacer muchos cálculos redundantes.
* Se aconseja usar valores pequeños de n y k, entre 0 y 30</p>
*
* @author Estudiante EPS estudiante.eps@uam.es
*
*/

public class Combinatoria{

	 
	private Map<Integer, Long> cache = new HashMap<>();

	private int posicion(int n, int k){
		
		int pos;
		pos= n*(n+1)/2 + k;
		return pos;

	} 
	/*
	* Si la clase tuviera atributos, los declararíamos aquí, como
	* private Tipo1 atributo1;
	* private Tipo2 atributo2;
	* ...
	* También se pueden inicializar al declararlos, por ejemplo
	* private int contador= 0;
	* El valor inicial también se puede asignar en el constructor
	*/

	/**
	* Ejemplo de constructor, en esta clase sería innecesario, ya que no tiene argumentos
	* ni inicializa atributos. El compilador crea uno igual si no existe.
	* Es importante que no devuelva nada (tampoco void), y que se llame como la clase.
	* Si fuese privado impediría crear objetos de este tipo desde otras clases.
	*/
	public Combinatoria(/* Argumentos para construir el objeto, si los hubiera */) {
		/* Esta clase no tiene atributos, por lo que este constructor vacío lo crearía
		* automáticamente el compilado, y no es necesario
		* Si tenemos un atributo (atributo1) con el mismo nombre que un argumento, podemos
		usar
		* "this.atributo1" para referirnos al atributo, y "atributo1" para el argumento
		* Por ejemplo podemos asignar el valor inicial con:
		* this.atributo1 = atributo1;
		*/
	}

	/**
	* Devuelve el número de combinaciones posibles de n elementos tomados de k en k
	* @param n Número de elementos totales
	* @param k Número de elementos, sin repetición, en cada combinación
	* @return valor del coeficiente binomial (n, k)
	*/
	public long combinaciones(int n, int k){

		long num;
		//Primero comprobamos si los argumentos son válidos
		if (n<0 || k <0) throw new IllegalArgumentException("n y k han de ser positivos");
		//Casos base
		else if (k == 0 || n==k ) return 1; //caso base para 1
		else if (k > n) return 0; //caso base para 0
		//caso general
		else{
			if (cache.containsKey(posicion(n, k))){
				return(cache.get(posicion(n, k)));
			}
			else{
				num =  combinaciones(n-1, k-1)+ combinaciones (n-1, k);
				cache.put(posicion(n, k), num);
				return num;
			}


			
		} 
	}

	/**
	* Punto de entrada a la aplicación.
	*
	* <p>Este método imprime el valor del coeficiente binomial de los 2 parámetros de entrada</p>
	*
	* @param args Los argumentos de la línea de comando. Se esperan dos números enteros, como cadenas
	*/
	public static void main(String[] args) {
		if (args.length!=2) {
			System.out.println("Se espera dos número como parámetro, n y k.");
			System.out.println(" n = Número total de elementos ");
			System.out.println(" k = Elementos en cada combinación");
			System.out.println("Devuelve el coeficiente binomial(n, k)");
		}
		else {
			int n = Integer.parseInt(args[0]); // convertimos String a int
			int k = Integer.parseInt(args[1]); // convertimos String a int
			Combinatoria c = new Combinatoria(); // Creamos un objeto c de tipo Combinatoria
			System.out.println(c.combinaciones(n, k)); // Imprimimos una línea por salida estándar
			// En java la destrucción de objetos es automática
		}
	}
}