package testers;
import cine.*;

public class TesterSesion {

	public static void main(String[] args) {
		Sala s = new Sala(1);
		Boolean check;
		
		// Generamos una pelicula
		Pelicula p = new Pelicula("La forma del Agua", "Alex de la Iglesia", 2018, "Increible pelicula", Genero.DRAMA, 120);
		
		
		/* 
		 * Intentamos crear 4 sesiones para esa pelicula. Aqui comprobamos
		 * que no se pueden solapar sesiones (s2 se solaparia a s1 y s4 a s3 
		 */
		Sesion s1 = new Sesion(2018, 12, 12, 18, 30, p, s);
		if (s1.getSala() == null) {
			System.out.println("No se ha podido crear la sesion correctamente1");
		}
		Sesion s2 = new Sesion(2018, 12, 12, 19, 00, p, s);
		if (s2.getSala() == null) {
			System.out.println("No se ha podido crear la sesion correctamente2");
		}
		Sesion s3 = new Sesion(2018, 11, 12, 20, 45, p, s);
		if (s3.getSala() == null) {
			System.out.println("No se ha podido crear la sesion correctamente3");
		}
		Sesion s4 = new Sesion(2018, 12, 12, 22, 16, p, s);
		if (s4.getSala() == null) {
			System.out.println("No se ha podido crear la sesion correctamente4");
		}
		
		
		/*
		 * Imprimimos las salas que se han creado
		 */
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		
		/*
		 * Actualizamos las butacas vendidas, es decir, simulamos que se vende
		 * una, y como la sala la hemos creado con una sola butaca comprobamos
		 * que devuelve true
		 */
		check = s1.actualizarButacasVendidas();
		if(check == false) {
			System.out.println("No hay más butacas.\n");
		}
		
		// Imprimimos la sala para comprobar que se ha actualizado
		System.out.println(s1);
		
		/*
		 * Actualizamos las butacas vendidas, es decir, simulamos que se vende
		 * otra, y como la sala la hemos creado con una sola butaca y ya hemos
		 * disminuido las butacas disponibles comprobamos que devuelve false
		 */
		check = s1.actualizarButacasVendidas();
		if(check == false) {
			System.out.println("No hay más butacas.\n");
		}
		
		// Volvemos a imprimir la sesion para comprobar que se actualiza correctamente
		System.out.println(s1);

	}
}
