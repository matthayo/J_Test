
public class QueueDriver {

	public static void main(String[] args) {
		
		final int SIZE = 5;
		
		Cashier[] cashier = new Cashier[SIZE];
		for(int i = 0; i < cashier.length; i++) {
			cashier[i] = new Cashier(i);
			cashier[i].start();
		}
		
		while(true) {
			
			Wait.wait(1000);
			System.out.println(cashier[0].toString());
		}
		
	}
}
