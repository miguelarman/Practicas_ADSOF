package otros;

import java.util.*;

import funciones.*;
import interfaces.INodo;
import terminales.TerminalAritmetico;

public class TesterSwap {

	public static void main(String[] args) {
		List<INodo> lista1 = new ArrayList<>();
		List<INodo> lista2 = new ArrayList<>();
		
		lista1.add(new TerminalAritmetico("x"));
		lista1.add(new FuncionMultiplicacion("*", 2));
		
		lista2.add(new FuncionSuma("+", 2));
		lista2.add(new FuncionResta("-", 2));
		
		
		lista2.get(0).incluirDescendiente(new TerminalAritmetico("x"));
		lista2.get(0).incluirDescendiente(new TerminalAritmetico("x"));
		
		lista2.get(1).incluirDescendiente(new TerminalAritmetico("x"));
		lista2.get(1).incluirDescendiente(new TerminalAritmetico("x"));
		
		lista1.get(1).incluirDescendiente(new TerminalAritmetico("x"));
		lista1.get(1).incluirDescendiente(lista2.get(1));
		
		System.out.print(lista1);
		System.out.print(lista2);
		
		// Swap
		
		int indice1 = 1;
		int indice2 = 1;
		
		INodo aux = lista1.get(indice1).copy();
		
		INodo aux1 = lista1.get(indice1);
		INodo aux2 = lista2.get(indice2);
		
		aux1 = aux2.copy();
		aux2 = aux.copy();
		
		lista1.remove(indice1);
		lista1.add(indice1, aux1);
		
		lista2.remove(indice2);
		lista2.add(indice2, aux2);
		
		System.out.println();
		System.out.println();
		System.out.print(lista1);
		System.out.print(lista2);
	}
}
