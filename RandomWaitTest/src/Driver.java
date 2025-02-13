import java.util.*;

public class Driver {

	private static Random rand = new Random();
	
	public static void main(String[] args) {
		
		int time = 0;
		
		while(true) {
			
			time = rand.nextInt(1000);
			
			wait(time);
			
			System.out.println("Waited for - " + time + "ms.");
		}

	}

	public static void wait(int ms)
	{
	    try
	    {
	        Thread.sleep(ms);
	    }
	    catch(InterruptedException ex)
	    {
	        Thread.currentThread().interrupt();
	    }
	}
}