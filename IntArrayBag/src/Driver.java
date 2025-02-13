
public class Driver {
	
	public static void main(String[] args) {
		
		IntArrayBag array1 = new IntArrayBag(20);
		
		int[] numbers = { 37, 22, 3, 87, 66, 94, 62, 97, 82, 17, 36, 4, 9, 77, 86, 14, 6, 80, 10, 96 };
		
		for(int i = 0; i < 20; i++) {
			array1.add(numbers[i]);
		}
		
		System.out.println(array1.toString());
		System.out.println("Number of items = " + array1.getNumberOfItems());
		System.out.println("Capacity = " + array1.getCapacity());
		
		for(int i = 0; i < 50; i++) {
			array1.add((int)(Math.random() * 100));
		}
		
		array1.add(966);
		
		System.out.println(array1.toString());
		System.out.println("Number of items = " + array1.getNumberOfItems());
		System.out.println("Capacity = " + array1.getCapacity());
		
		array1.remove(94);
		System.out.println(array1.toString());
		System.out.println("Number of items = " + array1.getNumberOfItems());
		System.out.println("Capacity = " + array1.getCapacity());
	}

}
