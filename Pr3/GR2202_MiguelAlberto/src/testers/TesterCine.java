package testers;

import cine.*;

public class TesterCine {

	public static void main(String[] args) {
		
		Boolean check;
		Cine c = new Cine("Cines x", "Paseo de mi casa, 27");
		
		//Imprimimos el cine		
		System.out.println(c);
		
		//Creamos una pel�cula
		Pelicula p1 = new Pelicula("La forma del Agua", "Alex de la Iglesia", 2018, "Increible pelicula", Genero.DRAMA, 120);
		
		//A�adimos la pel�cula al cine
		check = c.anadirPelicula(p1);
		if(!check) { //Comprobaci�n de errores
			System.out.println("Error al a�adir la pel�cula al cine\n");
		}
		
		//Imprimimos el cine
		System.out.println(c);
		
		//Creamos una sala
		Sala sa = new Sala(2);
		
		//A�adimos la sala al cine
		check = c.anadirSala(sa);
		if(!check) { //Comprobaci�n de errores
			System.out.println("Error al a�adir la sala al cine\n");
		}
		
		//Imprimimos el cine
		System.out.println(c);
		
		//Creamos una sesion en la sala creada anteriormente (cae en mi�rcoles, d�a del espectador)
		Sesion s1 = new Sesion(2018, 03, 21, 12, 00, p1, sa);
		if(s1.getSala() == null) { //Comprobaci�n de que la sesi�n se ha a�adido correctamente
			System.out.println("Error al crear la sesion\n");
		}
		
		//Imprimimos el cine
		System.out.println(c);
		
		//Creamos otra pel�cula nueva
		Pelicula p2 = new Pelicula("La forma del Agua 2", "Alex de la Iglesia", 2028, "Increible pelicula", Genero.DRAMA, 125);
		
		//A�adimos la pel�cula a la sesi�n de antes (va a fallar puesto que la pel�cula creada a�n no est� en el cine)
		check = c.anadirPeliculaASesion(p2.getTitulo(), s1);
		if(!check) { //Comprobaci�n de errores
			System.out.println("Error al anadir la pel�cula a la sesi�n\n");
		}
		
		//A�adimos la pel�cula al cine
		check = c.anadirPelicula(p2);
		if(!check) { //Comprobaci�n de errores
			System.out.println("Error a a�adir la pel�cula al cine\n");
		}
		
		//Imprimimos el cine
		System.out.println(c);
		
		//A�adimos la pel�cula a la sesi�n
		check = c.anadirPeliculaASesion(p2.getTitulo(), s1);
		if(!check) { //Comprobaci�n de errores
			System.out.println("Error al anadir la pel�cula a la sesi�n\n");
		}
		
		//Imprimimos la sesi�n para ver que la pel�cula se ha cambiado correctamente
		System.out.println(s1);		
		
		//Creamos otra sala
		Sala sa2 = new Sala(50);
		
		//A�adimos la nueva sesi�n a la sala (va a fallar, puesto que a�n no tenemos la sala en el cine)
		check = c.anadirSesionASala(s1, sa2.getIdentificador());
		if(!check) { //Comprobaci�n de errores
			System.out.println("Error al a�adir la sesi�n a la sala\n");
		}
		
		//A�adimos la nueva sala al cine
		check = c.anadirSala(sa2);
		if(!check) { //Comprobacion de errores
			System.out.println("Error al a�adir la sala al cine\n");
		}
		
		//A�adimos la nueva sesi�n a la sala
		check = c.anadirSesionASala(s1, sa2.getIdentificador());
		if(!check) { //Comprobaci�n de errores
			System.out.println("Error al a�adir la sesi�n a la sala\n");
		}
		
		//Imprimimos la sesi�n para ver que la sala se ha cambiado correctamente
		System.out.println(s1);
		
		//Imprimimos la informaci�n sobre la recaudaci�n (no hay entradas vendidas)
		System.out.println("Recaudaci�n: " + c.informacionRecaudacion());
		
		//Imprimimos la informaci�n de todas las pel�culas de la cartelera
		System.out.println("Cartelera: " + c.informacionCartelera());
		
		//Imprimimos la informaci�n de todas las sesiones del cine
		System.out.println("Sesiones: " + c.informacionSesiones());
		
		//Vendemos una entrada para s1 (dia del espectador)
		Entrada e = c.venderEntrada(s1);		
		if (e == null) { //Comprobaci�n de errores
			System.out.println("Error al vender la entrada\n");
		}
		
		//Imprimimos la entrada vendida
		System.out.println(e);
		
		//Imprimimos la informaci�n de la recaudaci�n (1 entradaDiaEspectador)
		System.out.println("Recaudaci�n: " + c.informacionRecaudacion());
		
		//Creamos una sesion en la sala creada anteriormente (cae en jueves, dia normal)
		Sesion s2 = new Sesion(2018, 03, 22, 12, 00, p1, sa);
		if(s2.getSala() == null) { //Comprobaci�n de que la sesi�n se ha a�adido correctamente
			System.out.println("Error al crear la sesion\n");
		}
		
		//Vendemos una entrada para s2
		Entrada e2 = c.venderEntrada(s2);		
		if (e2 == null) { //Comprobaci�n de errores
			System.out.println("Error al vender la entrada\n");
		}
		
		//Imprimimos la entrada vendida
		System.out.println(e2);
		
		//Imprimimos la informaci�n de la recaudaci�n (1 entradaDiaEspectador y 1 entrada)
		System.out.println("Recaudaci�n: " + c.informacionRecaudacion());
		
		//Imprimimos el cine para ver que todo est� correcto
		System.out.println(c);

	}

}
