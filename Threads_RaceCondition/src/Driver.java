
public class Driver {
	public static void main(String[] args) {
		
//		Counter[] thrd = new Counter[5];
//		
//		for(int i = 0; i < 5; i++) {
//			thrd[i] = new Counter(i);
//		}
//		
//		for(int i = 0; i < 5; i++) {
//			thrd[i].start();
//		}
//		
//		for(int i = 0; i < 5; i++) {
//			try {
//				thrd[i].join();
//			} catch (InterruptedException e) {
//	
//			}
//		}
		
		Counter counter = new Counter();
		
		RaceConditionTest[] thrd = new RaceConditionTest[30000];
		System.out.println("The counter is " + counter.getSum());
		
		for(int i = 0; i < thrd.length; i++) {
			thrd[i] = new RaceConditionTest(counter);
		}
		
		for(int i = 0; i < thrd.length; i++) {
			thrd[i].start();
		}
		
		for(int i = 0; i < thrd.length; i++) {
			try {
				thrd[i].join();
			} catch (InterruptedException e) {
			}
		}
		
		System.out.println("The counter is " + counter.getSum());
		
	}
}
