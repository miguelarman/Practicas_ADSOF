package testers;

import cine.*;

public class TesterPelicula {

	public static void main(String[] args) {

		// Creamos una pelicula
		Pelicula p = new Pelicula("La forma del Agua", "Alex de la Iglesia", 2018, "Increible pelicula", Genero.DRAMA,
				120);

		// Imprimimos la pelicula para ver que se guarda la informacion correctamente
		System.out.println(p);
	}

}
