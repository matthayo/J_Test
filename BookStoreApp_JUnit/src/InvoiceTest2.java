import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class InvoiceTest2 {

	private Invoice2 invoice;
	private static StringBuilder strBuilder;
    private static File file;
    private static PrintWriter writer;
    
    @BeforeAll
    public static void setUpAll() {
    	try {
    		file = new File("E:\\_Files\\InvoiceTest.txt");
			writer = new PrintWriter(file);
			strBuilder = new StringBuilder();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }

	@BeforeEach
	public void setUp() {
		// Create a new invoice instance before each test
		invoice = new Invoice2("Ann Apple");
	}

	@Test
	@Order(1)
	@DisplayName("GET Total from empty Invoice")
	public void testGetTotalWithNoBooks() {
		strBuilder.append("\n\n===== GET Total from empty Invoice =====\n");
		assertEquals(0.0, invoice.getTotal(), 0.001, "> GET Total from empty Invoice:"
				+ "\n\t[-] TEST FAILED");
		strBuilder.append("\n\t[+] TEST SUCCESSFUL");
	}

	@Test
	@Order(2)
	@DisplayName("GET DiscountedTotal from empty Invoice")
	public void testGetDiscountedTotalWithNoBooks() {
		strBuilder.append("\n\n===== GET DiscountedTotal from empty Invoice =====\n");
		assertEquals(0.0, invoice.getDiscountedTotal(), 0.001, "> GET DiscountedTotal from empty Invoice:"
				+ "\n\t[-] TEST FAILED");
		strBuilder.append("\n\t[+] TEST SUCCESSFUL");
	}

	@Test
	@Order(3)
	@DisplayName("GET TotalWeight from empty Invoice")
	public void testGetTotalWeightWithNoBooks() {
		strBuilder.append("\n\n===== GET TotalWeight from empty Invoice =====\n");
		assertEquals(0.0, invoice.getTotalWeight(), 0.001, "> GET TotalWeight from empty Invoice:"
				+ "\n\t[-] TEST FAILED");
		strBuilder.append("\n\t[+] TEST SUCCESSFUL");
	}

	@Test
	@Order(4)
	@DisplayName("ADD Book to Invoice")
	public void testAddBook() {
		strBuilder.append("\n\n===== ADD Book to Invoice =====\n");
		try {
			invoice.addBook("Book 1", 20.0, 1.0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		strBuilder.append("\n> GET Total: ");
		assertEquals(20.0, invoice.getTotal(), 0.001, "> Get Total:"
				+ "\n\t[-] TEST FAILED");
		strBuilder.append("\n\t[+] TEST SUCCESSFUL");
		// Assuming a 10% discount
		strBuilder.append("\n> GET DiscountedTotal: ");
		try {
			invoice.applyDiscount(0, 10);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		assertEquals(18.0, invoice.getDiscountedTotal(), 0.001, "> GET DiscountedTotal:"
				+ "\n\t[-] TEST FAILED");
		strBuilder.append("\n\t[+] TEST SUCCESSFUL"); 
		strBuilder.append("\n> GET TotalWeight: ");
		assertEquals(1.0, invoice.getTotalWeight(), 0.001, "> GET TotalWeight:"
				+ "\n\t[-] TEST FAILED");
		strBuilder.append("\n\t[+] TEST SUCCESSFUL");
	}

	@Test
	@Order(5)
	@DisplayName("ADJUST Price on Book #1")
	public void testAdjustPrice() {
		strBuilder.append("\n\n======ADJUST Price on Book #1 ======\n");
		try {
			invoice.addBook("Book 1", 20.0, 1.0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			invoice.adjustPrice(0, -5.0);
		}  catch (Exception e) {
			System.out.println(e.toString());
		}
		strBuilder.append("\n> GET Total: ");
		assertEquals(15.0, invoice.getTotal(), 0.001, "> GET Total:"
				+ "\n\t[-] TEST FAILED");
		strBuilder.append("\n\t[+] TEST SUCCESSFUL");
		strBuilder.append("\n> GET DiscountedTotal: ");
		try {
			invoice.applyDiscount(0, 10);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		assertEquals(13.5, invoice.getDiscountedTotal(), 0.001,"> GET DiscountedTotal:"
				+ "\n\t[-] TEST FAILED");
		strBuilder.append("\n\t[+] TEST SUCCESSFUL");
	}

	@Test
	@Order(6)
	@DisplayName("APPLY Discount to Book #1")
	public void testApplyDiscount() {
		strBuilder.append("\n===== APPLY Discount of Book #1 =====\n");

		try {
			invoice.addBook("Book 1", 20.0, 1.0);
		}  catch (Exception e) {
			System.out.println(e.toString());
		}
		try {
			invoice.applyDiscount(0, 15.0);
		}  catch (Exception e) {
			System.out.println(e.toString());
		}
		// Applying a 15% discount
		strBuilder.append("\n> GET Total: ");
		assertEquals(20.0, invoice.getTotal(), 0.001, "> GET Total:"
				+ "\n\t[-] TEST FAILED");
		strBuilder.append("\n\t[+] TEST SUCCESSFUL");
		try {
			invoice.applyDiscount(0, 15);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		strBuilder.append("\n> GET Discounted Total:");
		assertEquals(17.0, invoice.getDiscountedTotal(), 0.001, "> GET Discounted Total: "
				+ "\n\t[-] TEST FAILED");
		strBuilder.append("\n\t[+] TEST SUCCESSFUL");
	}

	@Test
	@Order(7)
	@DisplayName("CALCULATE Tax")
	public void testCalculateTax() {
		strBuilder.append("\n\n===== CALCULATE Tax ======\n");
		assertEquals(4.5, Invoice.calculateTax(100.0, 4.5), 0.001, "> CALCULATE Tax:"
				+ "\n\t[-] TEST FAILED");
		strBuilder.append("\n\t[+] TEST SUCCESSFUL");
	}
	    
    @AfterAll
    static void writeToFile() {
    	writer.print(strBuilder);
    	writer.close();
    }
}
