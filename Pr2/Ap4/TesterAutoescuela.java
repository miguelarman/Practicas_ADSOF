//package p2.autoescuela;
//import p2.autoescuela.clases.Alumno;
import java.util.*;

/**
* Tester del apartado opcional de la P2
* @author Miguel Arconada (miguel.arconada@estudiante.uam.es) y Alberto Gonzalez (alberto.gonzalezk@estudiante.uam.es)
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
		
		if (aux == false){
			System.out.println(1);
			return;
		}
		
		
		s = a.getFechaDocencia("73636488X");

		if (s == null){
			return;
		}		

		System.out.println("El profesor " + a.getNombrePorDni("73636488X") + " trabajó en la autoescuela " + a.getNombreAutoescuela() + " " + s + ".");
		
		
		// Comprobamos que admite más de una docencia por profesor en la misma autoescuela
		
		a.anadirProfesor("73636488X", "Antonio", "Pérez García", "654321098", "29348934", 0, 900, carnet, 2000, 12, 30);
		aux = a.finalizarDocente(2001, 12, 30, "73636488X");
		if (aux == false){
			System.out.println(2);
			return;
		}
		
		s = a.getFechaDocencia("73636488X");

		if (s == null){
			return;
		}		

		System.out.println("El profesor " + a.getNombrePorDni("73636488X") + " trabajó en la autoescuela " + a.getNombreAutoescuela() + " " + s + "");
		
		
		a.anadirProfesor("73636488X", "Antonio", "Pérez García", "654321098", "29348934", 0, 900, carnet, 2000, 12, 30);
	}
}