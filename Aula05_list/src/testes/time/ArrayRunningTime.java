package testes.time;

public class ArrayRunningTime {
	
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		
		int[] array = new int[1_000_000];
		for(int i=0; i<array.length; i++)
			array[i] = i;
		
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.print("Running time array");
		System.out.println(totalTime);
	}

}
