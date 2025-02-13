import java.util.NoSuchElementException;
import java.util.Random;

public class Cashier extends Thread {
	// PROPERTIES
	private String queueId;
	private ArrayQueue<Customer> queue;
	
	private static int idCounter = 0;
	private Random rand;

	public Cashier() {
		this.queueId = String.format("%02d", ++idCounter);
		this.queue = new ArrayQueue<Customer>();
		this.rand = new Random(100);
	}

	public String getQueueId() {
		return this.queueId;
	}

	public void run() {
		try {
			while(true) {
				addToQueue();
				removeFromQueue();
			}
		} catch (InterruptedException e) {
			e.getMessage();
		} catch (NoSuchElementException e) {
			e.getMessage();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public int size() {
		return this.queue.size();
	}

	synchronized public void addToQueue() throws InterruptedException {
		int time = rand.nextInt(1) % 100;
		Wait.wait(time);
		this.queue.add(new Customer());
	}

	synchronized public void removeFromQueue() throws InterruptedException, NoSuchElementException, Exception {
		int time = rand.nextInt(1) % 100;
		Wait.wait(time);
		if(this.queue.size() != 0 )
			this.queue.remove();
	}

	public String toString() {
		return this.queueId + " ==> " + this.queue.toString();
	}

}
