
public class Driver {
	public static void main(String[] args) {

		GroceryStore groceryStore = new GroceryStore();
		try {

			groceryStore.start();
			
			// Run
			int time = 100;
			int elapseTime = 0;
			while(elapseTime < time) {
				System.out.println("Time => " + (++elapseTime));
				Wait.wait(100);
				System.out.println(groceryStore.toString());
			}
			
			groceryStore.join();


		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
