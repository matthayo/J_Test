
public class Driver {
	public static void main(String[] args) {
		
		final long MAX = 2200000000L;
		
		long startTime;
		long endTime;
		startTime = System.nanoTime();
		for(int i = 1; i <= MAX; i++) {
			continue;
		}
		endTime = System.nanoTime();
		System.out.println();
		System.out.println("Time: " + (endTime - startTime)/1000000000.0 + " seconds");
		
	
	}
}
