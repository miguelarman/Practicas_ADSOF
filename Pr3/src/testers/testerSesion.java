package testers;
import cine.*;

public class testerSesion {

	public static void main(String[] args) {
		Sala s = new Sala(1);
		Boolean check;
		Pelicula p = new Pelicula("La forma del Agua", "Alex de la Iglesia", 2018, "Increible pelicula", Genero.DRAMA, 120);
		Sesion s1 = new Sesion(2018, 12, 12, 18, 30, p, s);
		Sesion s2 = new Sesion(2018, 12, 12, 19, 00, p, s);
		Sesion s3 = new Sesion(2018, 11, 12, 20, 45, p, s);
		Sesion s4 = new Sesion(2018, 12, 12, 22, 16, p, s);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		check = s1.actualizarButacasVendidas();
		if(check == false) {
			System.out.println("No hay más butacas.\n");
		}
		System.out.println(s1);
		check = s1.actualizarButacasVendidas();
		if(check == false) {
			System.out.println("No hay más butacas.\n");
		}
		System.out.println(s1);

	}

}
