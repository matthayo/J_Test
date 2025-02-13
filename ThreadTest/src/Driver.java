

public class Driver {

	public static void main(String[] args) {
		Counter thread1 = new Counter();
		Counter thread2 = new Counter();
		Counter thread3 = new Counter();
		
		thread1.start();
		thread2.start();
		thread3.start();


		try {
			thread1.join();
			thread2.join();
			thread3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Counter = " + Counter.getCounter());
	}
}

