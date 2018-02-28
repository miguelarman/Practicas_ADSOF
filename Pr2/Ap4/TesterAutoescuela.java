//package p2.autoescuela;
//import p2.autoescuela.clases.Alumno;
import java.util.*;

/**
* Tester el primer apartado de la P2
* @author Profesores ADS
*/
public class TesterAutoescuela {
	public static void main(String[] args) {

		Boolean aux;
		String s;
		List<String> carnet= new ArrayList<String>();
		carnet.add("B");
		carnet.add("C");
		Autoescuela a = new Autoescuela("1234", "Arenal","Calle X", "Pepito Perez");

		a.anadirProfesor("73636488X", "Antonio", "Pérez García", "654321098", "29348934", 0, 900, carnet, 1998, 12, 30);
		aux = a.finalizarDocente(1999, 12, 30, "73636488X");

		if(aux == false){
			System.out.println(1);
			return;
		}
		
		s = a.getFechaDocencia("73636488X");

		if (s == null){
			System.out.println(2);
			return;
		}		

		System.out.println("El profesor Antonio Pérez García trabajó en la autoescuela " + a.getNombreAutoescuela() + " " + s);
	}
}