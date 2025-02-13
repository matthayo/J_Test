import java.util.Random;

@SuppressWarnings("rawtypes")
public class Cashier extends Thread{
	// Cashier queue
	private int qNumber;
	private ArrayQueue cashierQueue;
	private Random rand;
	
	// CONSTRUCTOR
	public Cashier(int qNumber){
		this.qNumber = qNumber;
		cashierQueue = new ArrayQueue<Integer>();
		rand = new Random();
	}
	
	public void run() {
		int time = 0;
		while(true) {
			time = rand.nextInt(1000);
			Wait.wait(time);
			System.out.println("Queue #" + this.qNumber + " : Wait time =\t" + time + "ms\n");
		}
	}

}
