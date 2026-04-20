package testes.time;

import java.util.Vector;

public class VectorRunningTime {
	
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		
		Vector<Integer> vector = new Vector<>();
		for(int i=0; i<1_000_000; i++)
			vector.add(i);
		
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.print("Running time vector");
		System.out.println(totalTime);
	}

}
