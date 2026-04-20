package testes.time;

import java.util.ArrayList;
import java.util.List;

public class LinkedListRunningTime {
	
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		
		List<Integer> lista = new ArrayList<>();
		for(int i=0; i<1_000_000; i++)
			lista.add(i);
		
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.print("Running time linked list");
		System.out.println(totalTime);
	}

}
