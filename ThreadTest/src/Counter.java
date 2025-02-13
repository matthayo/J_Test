
public class Counter extends Thread{
	private static int counter = 0;
	
	public Counter() {
		
	}
	
	public void run() {
		for(int i = 0; i < 3000000; i++)
			counter = counter + 1;
	}
	
//	public void run() {
//		for(int i = 0; i < 3000000; i++)
//			increment();
//	}
//	
//	public static synchronized void increment() {
//		counter = counter + 1;
//	}
	
	public static int getCounter() {
		return counter;
	}
}