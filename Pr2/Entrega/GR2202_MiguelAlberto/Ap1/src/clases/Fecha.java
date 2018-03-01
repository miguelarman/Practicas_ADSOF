package Ap1.src.clases;

/**
* Esta clase será utilizada para guardar fechas
* <p><b>Nota</b>: Para guardar una fecha en esta clase, al contructor hay que pasarle los atributos en el orden AAAA MM DD</p>
*
* @author Miguel Arconada (miguel.arconada@estudiante.uam.es) y Alberto Gonzalez (alberto.gonzalezk@estudiante.uam.es)
*
*/


public class Fecha {

	private int anyo;
	private int mes;
	private int dia;



	/**
	* Constructor de la clase. Devuelve un nuevo objeto de la clase Fecha.
	* @param anyo Número del año de la fecha a construir
	* @param mes Número del mes de la fecha a construir
	* @param dia Número del día de la fecha a construir
	* @return objeto de la clase fecha con los valores anteriores
	*/
	public Fecha(int anyo, int mes, int dia) {
		this.anyo = anyo;
		this.mes = mes;
		this.dia = dia;
	}

	/**
	* Genera la cadena de caracteres que al ser imprimida genera el triangulo
	* @param ninguno
	* @return una cadena de caracteres en la que está contenida la fecha en formato imprimible
	*/
	public String toString() {

		String cadena;

		cadena = "" + anyo + "-" + mes + "-" + dia;

		return cadena;
	}


	/**
	* Comprueba si una fecha es válida, es decir, el día tiene coherencia con el mes, además de evitar valores negativos, y superiores a 12 en el caso de los meses
	* @return un valor booleano representando si la fecha es válida
	*/
	public boolean isFechaValida() {

		if (dia > 31 || dia < 1 || mes > 12 || mes < 1) {
			return false;
		}

		if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30){
			return false;
		}

		if (mes == 2 && dia > 28) {
			return false;
		}

		/*Comprobacion de bisiestos*/

		return true;
	}
}