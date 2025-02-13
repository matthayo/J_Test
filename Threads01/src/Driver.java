
public class Driver {
	public static void main(String[] args) {
//		NamedThread greetings = new NamedThread("Thread");
//		greetings.start();
		
//		NamedRunnable greetings = new NamedRunnable("Thread");
//		Thread greetingsThread = new Thread(greetings);
//		greetingsThread.start();
		
		Thread greetingsThread02 = new Thread(
				() -> {
					for(int i = 0; i < 500; i++)
						System.out.println("Thread => Count - " + i );
				}
				);
		greetingsThread02.start();
		
		for(int i = 0; i < 500; i++)
			System.out.println("Main => Count - " + i );
		
		
	}
}
