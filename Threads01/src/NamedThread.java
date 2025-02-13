
public class NamedThread extends Thread{
	private String name;
	
	public NamedThread(String name) {
		this.name = name;
	}
	
	public void run() {
		for(int i = 0; i < 500; i++)
			System.out.println(this.name + " => Count - " + i);
	}
}
