package testers;

import cine.*;
import java.util.*;

public class TesterFechas {

	public static void main(String[] args) {
		Sala sala = new Sala(400);
		Pelicula peli = new Pelicula("El pirata Marabini", "Del valle", 2001, "una mierda", Genero.INFANTIL, 60);
		Sesion sesion1, sesion2;
		Date date1 = new Date(2018, 12, 31, 23, 59), date2 = new Date(2019, 02, 01, 00, 30);
		Boolean retorno;
		
		sesion1 = new Sesion(date1, peli, sala);
		sesion2 = new Sesion(date2, peli, sala);
		
		retorno = sala.anadirSesion(sesion1);
		System.out.println(retorno);
		
		retorno = sala.anadirSesion(sesion2);
		System.out.println(retorno);
	}

}
