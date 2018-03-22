package testers;

import cine.*;

public class TesterCine {

	public static void main(String[] args) {
		Cine c = new Cine("Cines x", "Paseo de mi casa, 27");
		
		System.out.println(c);
		
		
		Pelicula p1 = new Pelicula("La forma del Agua", "Alex de la Iglesia", 2018, "Increible pelicula", Genero.DRAMA, 120);
		c.anadirPelicula(p1);
		System.out.println(c);
		
		Sala sa = new Sala(2);
		c.anadirSala(sa);
		System.out.println(c);
		
		Sesion s1 = new Sesion(2018, 03, 21, 12, 00, p1, sa);
		System.out.println(c);
		
		
		System.out.println(s1);
		
		Pelicula p2 = new Pelicula("La forma del Agua 2", "Alex de la Iglesia", 2028, "Increible pelicula", Genero.DRAMA, 125);
		c.anadirPelicula(p2);
		System.out.println(c);
		
		c.anadirPeliculaASesion(p2.getTitulo(), s1);
		System.out.println(s1);
		
		
		
		
		Sala sa2 = new Sala(50);
		c.anadirSala(sa2);
		
		c.anadirSesionASala(s1, sa2.getIdentificador());
		System.out.println(s1);
		
		
		
		/*Informaciones*/
		
		System.out.println("Recaudaci�n: " + c.informacionRecaudacion());
		
		System.out.println("Cartelera: " + c.informacionCartelera());
		
		System.out.println("Sesiones: " + c.informacionSesiones());
		
		
		
		Entrada e = new Entrada(s1);
		Boolean comprobacion = c.anadirEntrada(e);
		if (!comprobacion) {
			System.out.println("No se ha podido a�adir la entrada");
		}
		
		System.out.println("Recaudaci�n: " + c.informacionRecaudacion());
		
		EntradaDiaEspectador ee = new EntradaDiaEspectador(s1);
		comprobacion = c.anadirEntrada(ee);
		if (!comprobacion) {
			System.out.println("No se ha podido a�adir la entrada");
		}
		
		System.out.println("Recaudaci�n: " + c.informacionRecaudacion());
		
		
		Entrada entradaAux = c.venderEntrada(s1);
		if (entradaAux == null) {
			System.out.println("No se ha podido crear la entrada");
		}
		System.out.println("Recaudaci�n: " + c.informacionRecaudacion());
		
		
		entradaAux = c.venderEntrada(s1);
		if (entradaAux == null) {
			System.out.println("No se ha podido crear la entrada");
		}
		System.out.println("Recaudaci�n: " + c.informacionRecaudacion());
		
		System.out.println(c);

	}

}
