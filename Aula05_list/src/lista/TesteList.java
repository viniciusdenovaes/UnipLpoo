package lista;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TesteList {
	
	public static void main(String[] args) {
		
		List<Double> lista = new ArrayList<>();
		lista.add(5.0);
		lista.add(4.);
		lista.add(15.);
		lista.add(-5.);
		lista.add(-5.);
		lista.add(-5.);
		
		
		
		for(var e: lista) {
			System.out.println(e);
		}
		
		lista.set(2, 1_000.);
		
		System.out.println(lista);
		
		lista.remove(4.);
		
		System.out.println(lista);
		
	}

}
