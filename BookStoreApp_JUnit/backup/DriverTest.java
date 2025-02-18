
public class DriverTest {

	public static void main(String[] args) throws Exception {

		Invoice invoice1 = new Invoice("Ann Apple");
		Invoice invoice2 = new Invoice("Bob Berry");

		try {
			invoice1.addBook("Programming with C++" , 1.5 , 120.00);
			invoice1.addBook("Starting With Objects" , 2.0 , 150.00);
			invoice1.addBook("Intro to Data Structures" , 1.0 , 80.00);
			invoice2.addBook("Intro to Statistic" , 0.8 , 54.00);
			invoice2.addBook("Data Science" , 4.5 , 180.00);
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
