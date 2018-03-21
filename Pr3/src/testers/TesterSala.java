package testers;
import cine.*;

public class TesterSala {

	public static void main(String[] args) {
		
		Sala s1 = new Sala(20);
		Sala s2 = new Sala(50);
		
		System.out.println(s1);
		System.out.println(s2);
				
		Pelicula p = new Pelicula("La forma del Agua", "Alex de la Iglesia", 2018, "Increible pelicula", Genero.DRAMA, 120);
		
		Sesion ses1 = new Sesion(2018, 12, 12, 18, 30, p, s1);
		Sesion ses2 = new Sesion(2018, 12, 12, 19, 00, p, s1);
		Sesion ses3 = new Sesion(2018, 11, 12, 19, 00, p, s2);
		Sesion ses4 = new Sesion(2018, 12, 12, 22, 00, p, s1);
		
		System.out.println(s1);
		System.out.println(s2);
		

	}

}
