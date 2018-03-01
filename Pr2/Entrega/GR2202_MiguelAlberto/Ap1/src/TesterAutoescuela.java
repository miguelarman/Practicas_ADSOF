package Ap1.src;
import Ap1.src.clases.*;


/**
* Tester el primer apartado de la P2
* @author Profesores ADS
*/
public class TesterAutoescuela {
	public static void main(String[] args) {
		Alumno a1=new Alumno("3141243T","Jose", "Jimenez",2016,10,3,"A");
		Alumno a2=new Alumno("3141243T","Sandra", "Goya",2016,22,3,"C");
		Alumno a3=new Alumno("3141243T","Carlos","Pascual",2015,2,29,"E");


		Fecha c1= a1.getFechaMatr();
		Fecha c2= a2.getFechaMatr();
		Fecha c3= a3.getFechaMatr();


		System.out.println("isValida <" + c1 + "> ? " + c1.isFechaValida());
		System.out.println("isValida <" + c2 + "> ? " + c2.isFechaValida());
		System.out.println("isValida <" + c3 + "> ? " + c3.isFechaValida());
		System.out.println("Datos de alumno 1:\n" + a1);
		System.out.println();
	}
}