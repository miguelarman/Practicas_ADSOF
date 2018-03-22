package testers;

import cine.*;

public class TesterSala {

	public static void main(String[] args) {

		Boolean check;

		// Creamos dos salas
		Sala s1 = new Sala(20);
		Sala s2 = new Sala(50);

		// Imprimimos la informacion de las dos salas
		System.out.println(s1);
		System.out.println(s2);

		Pelicula p = new Pelicula("La forma del Agua", "Alex de la Iglesia", 2018, "Increible pelicula", Genero.DRAMA,
				120);

		// Creamos sesiones en estas salas
		Sesion sesion1 = new Sesion(2018, 12, 12, 18, 30, p, s1);
		new Sesion(2018, 12, 12, 19, 00, p, s1);
		new Sesion(2018, 11, 12, 19, 00, p, s2);
		Sesion sesion2 = new Sesion(2018, 12, 12, 22, 00, p, s1);

		/*
		 * Volvemos a imprimir la informacion de las salas para comprobar que se
		 * actualiza correctamente
		 */
		System.out.println(s1);
		System.out.println(s2);

		// Borramos una sesion de la sala
		check = s1.removeSesion(sesion1);
		if (!check) {
			System.out.println("No se ha podido eliminar la sesion correctamente");
		}

		// Imprimimos las salas para comprobar que se eliminan las sesiones
		System.out.println(s1);
		System.out.println(s2);

		
		
		// Intentamos borrar una sesion que no esta en la sala
		check = s2.removeSesion(sesion2);
		if (!check) {
			System.out.println("No se ha podido eliminar la sesion correctamente");
		}

		// Imprimimos las salas para comprobar que no se ha eliminado nada
		System.out.println(s1);
		System.out.println(s2);

	}

}
