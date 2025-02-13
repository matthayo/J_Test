import java.util.*;

public class GroceryStore extends Thread {
	// PROPERTIES
	
	private Cashier[] cashier;
	private final int SIZE = 5;
	
	// Helper properties
	private int time = 1000000;
	private int elapsedTime = 0;

	
	public GroceryStore() {
		
		cashier = new Cashier[SIZE];
		for(int i = 0; i < SIZE; i++) {
			cashier[i] = new Cashier();
			cashier[i].start();
		}
	}
	
	public void run() {
		try {
			
			while(elapsedTime < time) {
				addToAQueue();
				removeFromAQueue();
				elapsedTime++;
			}
			
			for(int i = 0; i < SIZE; i++)
				this.cashier[i].join();

		} catch (InterruptedException e) {
			e.getMessage();
		} catch (NoSuchElementException e) {
			e.getMessage();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void addToAQueue() throws InterruptedException {
		int shortest = cashier[0].size();
		int index = 0;
		
		for(int i = 1; i < SIZE; i++) {
			if(cashier[i].size() < shortest) {
				index = i;
			}
		}
		cashier[index].addToQueue();
	}
	
	public void removeFromAQueue() throws NoSuchElementException, Exception {
		int i = (int)(Math.random() % 5);
		this.cashier[i].removeFromQueue();
	}
	
	public String toString() {
		String result = "";
		
		for(int i = 0; i < SIZE; i++)
			result += cashier[i].toString() + "\n";
		
		return result;
	}
}
