
public class RaceConditionTest extends Thread {
	private Counter counterObj;

	public RaceConditionTest(Counter counterObj) {
		this.counterObj = counterObj;
	}
	
	public void run() {
		counterObj.summation();
	}
}
