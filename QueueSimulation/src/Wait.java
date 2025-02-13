
public class Wait {
	public static void wait(int milisc) {
		try {
			Thread.sleep(milisc);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
}
