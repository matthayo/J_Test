
public class DriverTest2 {

	public static void main(String[] args) throws Exception {

		Invoice2 invoice1 = new Invoice2("Ann Apple");
		Invoice2 invoice2 = new Invoice2("Bob Berry");

		try {
			invoice1.addBook("Programming with C++" , 120.0 , 1.5);
			invoice1.addBook("Starting With Objects" , 150.0 , 2.0);
			invoice1.addBook("Intro to Data Structures" , 80.0 , 1.0);
			invoice2.addBook("Intro to Statistic" , 54.0 , 0.8);
			invoice2.addBook("Data Science" , 180.0 , 4.5);
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println(ex.toString());
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}

		try {
			invoice1.applyDiscount(0, 10.0);
			invoice1.applyDiscount(1, 20.0);

			invoice2.applyDiscount(0, 10.0);
			invoice2.applyDiscount(1, 20.0);
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println(ex.toString());
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}

		try {
			invoice2.adjustPrice(2, 2.0);
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println(ex.toString());
		} catch (NullPointerException ex) {
			System.out.println(ex.toString());
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}

		System.out.println(invoice1);
		System.out.println(invoice2);
		
	}

}
