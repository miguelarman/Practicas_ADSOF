public class Fecha {

	private int anyo;
	private int mes;
	private int dia;




	public Fecha(int anyo, int mes, int dia) {
		this.anyo = anyo;
		this.mes = mes;
		this.dia = dia;
	}


	public String toString() {

		String cadena;

		cadena = "" + anyo + "-" + mes + "-" + dia;

		return cadena;
	}


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