package testes.time;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

public class TestRunningTimes {
	
	static final int MAX_POW2 = 29; // max pow of 2 to fit a int
	
	// test colecao, if null test array 
	public static int test(Collection<Integer> colecao, int pow2) {
		if(pow2>MAX_POW2) throw new IllegalArgumentException("limit of pow for int is " + MAX_POW2);
		int expoent = 2 << pow2; // 2^pow2
		
		long startTime = System.nanoTime();
		
		if(colecao==null)
			runArray(expoent);
		else
			runCollection(colecao, expoent);
		
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		long durationInMs = TimeUnit.NANOSECONDS.toMillis(totalTime);
		if(durationInMs > (2<<MAX_POW2)) 
			throw new RuntimeException(
					"Total time in Ms greater than int: totalTime(" + totalTime + 
					"), totalTimeMs(" + durationInMs + ")");
		return (int)durationInMs;

	}
	
	public static void runCollection(Collection<Integer> colecao, int expoent) {
		for(int i=0; i<expoent; i++)
			colecao.add(i);
	}
	
	public static void runArray(int expoent) {
		int[] array = new int[expoent];
		for(int i=0; i<array.length; i++)
			array[i] = i;
	}
	
	public static void main(String[] args) {
		int pow2 = 21;
		System.out.println(String.format("Running time array:      %5d Ms", test(null, pow2)));
		System.out.println(String.format("Running time ArrayList:  %5d Ms", test(new ArrayList<>(), pow2)));
		System.out.println(String.format("Running time LinkedList: %5d Ms", test(new LinkedList<>(), pow2)));
		System.out.println(String.format("Running time Vector:     %5d Ms", test(new Vector<>(), pow2)));
	}

}
