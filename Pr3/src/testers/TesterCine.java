package testers;

import cine.*;

public class TesterCine {

	public static void main(String[] args) {
		
		Boolean check;
		Cine c = new Cine("Cines x", "Paseo de mi casa, 27");
		
		//Imprimimos el cine		
		System.out.println(c);
		
		//Creamos una película
		Pelicula p1 = new Pelicula("La forma del Agua", "Alex de la Iglesia", 2018, "Increible pelicula", Genero.DRAMA, 120);
		
		//Añadimos la película al cine
		check = c.anadirPelicula(p1);
		if(!check) { //Comprobación de errores
			System.out.println("Error al añadir la película al cine\n");
		}
		
		//Imprimimos el cine
		System.out.println(c);
		
		//Creamos una sala
		Sala sa = new Sala(2);
		
		//Añadimos la sala al cine
		check = c.anadirSala(sa);
		if(!check) { //Comprobación de errores
			System.out.println("Error al añadir la sala al cine\n");
		}
		
		//Imprimimos el cine
		System.out.println(c);
		
		//Creamos una sesion en la sala creada anteriormente (cae en miércoles, día del espectador)
		Sesion s1 = new Sesion(2018, 03, 21, 12, 00, p1, sa);
		if(s1.getSala() == null) { //Comprobación de que la sesión se ha añadido correctamente
			System.out.println("Error al crear la sesion\n");
		}
		
		//Imprimimos el cine
		System.out.println(c);
		
		//Creamos otra película nueva
		Pelicula p2 = new Pelicula("La forma del Agua 2", "Alex de la Iglesia", 2028, "Increible pelicula", Genero.DRAMA, 125);
		
		//Añadimos la película a la sesión de antes (va a fallar puesto que la película creada aún no está en el cine)
		check = c.anadirPeliculaASesion(p2.getTitulo(), s1);
		if(!check) { //Comprobación de errores
			System.out.println("Error al anadir la película a la sesión\n");
		}
		
		//Añadimos la película al cine
		check = c.anadirPelicula(p2);
		if(!check) { //Comprobación de errores
			System.out.println("Error a añadir la película al cine\n");
		}
		
		//Imprimimos el cine
		System.out.println(c);
		
		//Añadimos la película a la sesión
		check = c.anadirPeliculaASesion(p2.getTitulo(), s1);
		if(!check) { //Comprobación de errores
			System.out.println("Error al anadir la película a la sesión\n");
		}
		
		//Imprimimos la sesión para ver que la película se ha cambiado correctamente
		System.out.println(s1);		
		
		//Creamos otra sala
		Sala sa2 = new Sala(50);
		
		//Añadimos la nueva sesión a la sala (va a fallar, puesto que aún no tenemos la sala en el cine)
		check = c.anadirSesionASala(s1, sa2.getIdentificador());
		if(!check) { //Comprobación de errores
			System.out.println("Error al añadir la sesión a la sala\n");
		}
		
		//Añadimos la nueva sala al cine
		check = c.anadirSala(sa2);
		if(!check) { //Comprobacion de errores
			System.out.println("Error al añadir la sala al cine\n");
		}
		
		//Añadimos la nueva sesión a la sala
		check = c.anadirSesionASala(s1, sa2.getIdentificador());
		if(!check) { //Comprobación de errores
			System.out.println("Error al añadir la sesión a la sala\n");
		}
		
		//Imprimimos la sesión para ver que la sala se ha cambiado correctamente
		System.out.println(s1);
		
		//Imprimimos la información sobre la recaudación (no hay entradas vendidas)
		System.out.println("Recaudación: " + c.informacionRecaudacion());
		
		//Imprimimos la información de todas las películas de la cartelera
		System.out.println("Cartelera: " + c.informacionCartelera());
		
		//Imprimimos la información de todas las sesiones del cine
		System.out.println("Sesiones: " + c.informacionSesiones());
		
		//Vendemos una entrada para s1 (dia del espectador)
		Entrada e = c.venderEntrada(s1);		
		if (e == null) { //Comprobación de errores
			System.out.println("Error al vender la entrada\n");
		}
		
		//Imprimimos la entrada vendida
		System.out.println(e);
		
		//Imprimimos la información de la recaudación (1 entradaDiaEspectador)
		System.out.println("Recaudación: " + c.informacionRecaudacion());
		
		//Creamos una sesion en la sala creada anteriormente (cae en jueves, dia normal)
		Sesion s2 = new Sesion(2018, 03, 22, 12, 00, p1, sa);
		if(s2.getSala() == null) { //Comprobación de que la sesión se ha añadido correctamente
			System.out.println("Error al crear la sesion\n");
		}
		
		//Vendemos una entrada para s2
		Entrada e2 = c.venderEntrada(s2);		
		if (e2 == null) { //Comprobación de errores
			System.out.println("Error al vender la entrada\n");
		}
		
		//Imprimimos la entrada vendida
		System.out.println(e2);
		
		//Imprimimos la información de la recaudación (1 entradaDiaEspectador y 1 entrada)
		System.out.println("Recaudación: " + c.informacionRecaudacion());
		
		//Imprimimos el cine para ver que todo está correcto
		System.out.println(c);

	}

}
