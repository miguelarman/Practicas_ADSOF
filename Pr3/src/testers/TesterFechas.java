package testers;

import cine.*;

public class TesterFechas {

	public static void main(String[] args) {
		Sala sala = new Sala(400);
		Pelicula peli = new Pelicula("El pirata Marabini", "Del valle", 2001, "una mierda", Genero.INFANTIL, 60);
		Sesion sesion1, sesion2;
		Boolean retorno;
		
		sesion1 = new Sesion(2018, 12, 31, 23, 59, peli, sala);
		sesion2 = new Sesion(2019, 01, 01, 00, 30, peli, sala);
		
		retorno = sala.anadirSesion(sesion1);
		System.out.println(retorno);
		
		retorno = sala.anadirSesion(sesion2);
		System.out.println(retorno);
	}

}
