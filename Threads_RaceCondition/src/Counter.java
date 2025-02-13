
public class Counter extends Thread {
	private int sum;
	
	public Counter() {
		this.sum = 0;
	}
	
//	public void run() {
//		display();
//	}

//	public void display() {
//		try {
//			Thread.sleep(10000);
//			System.out.println("Thread #" + this.id + " executed!");
//		} catch (InterruptedException e) {
//			
//		}
//	}
	
	public synchronized void summation() {
			this.sum++;
	}
	
	public int getSum() {
		return this.sum;
	}
	
}
