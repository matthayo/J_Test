
public class NamedRunnable implements Runnable{
	private String name;
	
	public NamedRunnable(String name) {
		this.name = name;
	}
	
	public void run() {
		for(int i = 0; i < 500; i++)
			System.out.println(this.name + " => Count - " + i);
	}

}
