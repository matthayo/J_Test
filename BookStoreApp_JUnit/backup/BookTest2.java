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

public class BookTest2 {

    private Book book;
    private static StringBuilder strBuilder;
    private static File file;
    private static PrintWriter writer;
    
    @BeforeAll
    public static void setUpAll() {
    	try {
    		file = new File("E:\\_Files\\BookTest.txt");
			writer = new PrintWriter(file);
			strBuilder = new StringBuilder();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }
		

    @BeforeEach
    public void setUp() {
        // Create a new book instance before each test
        book = new Book("Sample Book", 25.0, 1.5);
    }

    @Test
    @Order(1)
    @DisplayName("GET Title")
    public void testGetTitle() {
    	strBuilder.append("\n===== GET Title =====\n");
        assertEquals("Sample Book", book.getTitle(), "GET Title: "
        		+ "\n\t[-] TEST FAILED");
        strBuilder.append("\t[+] TEST SUCCESSFUL");
    }

    @Test
    @Order(2)
    @DisplayName("GET Weight")
    public void testGetWeight() {
    	strBuilder.append("\n\n===== GET Weight ======\n");
        assertEquals(1.5, book.getWeight(), 0.001, "GET Weight: " + 
        		"\n\t[-] TEST FAILED");
        strBuilder.append("\t[+] TEST SUCCESSFUL"); // Use delta for double comparison
    }

    @Test
    @Order(3)
    @DisplayName("GET Price")
    public void testGetPrice() {
    	strBuilder.append("\n\n===== GET Price ======\n");
        assertEquals(25.0, book.getPrice(), 0.001, "GET Price: " + 
        		"\n\t[-] TEST FAILED");
        strBuilder.append("\t[+] TEST SUCCESSFUL");
    }

    @Test
    @Order(4)
    @DisplayName("GET Discount")
    public void testGetDiscount() {
    	strBuilder.append("\n\n===== GET Discount ======\n");
        assertEquals(0, book.getDiscount(), 0.001, "GET Discount: " + 
        		"\n\t[-] TEST FAILED");
        strBuilder.append("\t[+] TEST SUCCESSFUL");
    }

    @Test
    @Order(5)
    @DisplayName("SET Discount")
    public void testSetDiscount() {
    	strBuilder.append("\n\n===== SET Discount ======\n");
        book.setDiscount(10.0);
        assertEquals(0.10, book.getDiscount(), 0.001, "SET Discount" + 
        		"\n\t[-] TEST FAILED");
        strBuilder.append("\t[+] TEST SUCCESSFUL");
    }

    @Test
    @Order(6)
    @DisplayName("ADJUST Price")
    public void testAdjustPrice() {
    	strBuilder.append("\n\n===== ADJUST Price ======\n");
        book.adjustPrice(5.0);
        assertEquals(30.0, book.getPrice(), 0.001, "ADJUST Price:" +  
        		"\n\t[-] TEST FAILED");
        strBuilder.append("\t[+] TEST SUCCESSFUL");
    }

    @Test
    @Order(7)
    @DisplayName("GET Price After Discount")
    public void testPriceAfterDiscount() {
    	strBuilder.append("\n\n===== GET Price After Discount ======\n");
        book.setDiscount(10.0);
        assertEquals(22.5, book.priceAfterDiscount(), 0.001, "GET Price After Discount: " + 
        		"\n\t[-] TEST FAILED");
		strBuilder.append("\t[+] TEST SUCCESSFUL");
    }

    @Test
    @Order(8)
    @DisplayName("TEST Equals")
    public void testEquals() {
    	strBuilder.append("\n\n===== TEST Equals ======\n");
        Book sameBook = new Book("Sample Book", 25.0, 1.5);
        strBuilder.append("\t=> TEST for Equality ");
        assertTrue(book.equals(sameBook), "TEST Equals: " + 
        		"\n\t[-] TEST FAILED");
		strBuilder.append("\n\t\t[+] TEST SUCCESSFUL");
        
		strBuilder.append("\n\t=> TEST for Inequality ");
        Book differentBook = new Book("Another Book", 30.0, 2.0);
        assertFalse(book.equals(differentBook), "TEST Equals: " + 
        		"\n\t[-] TEST FAILED");
		strBuilder.append("\n\t\t[+] TEST SUCCESSFUL");
    }
    
    @AfterAll
    static void writeToFile() {
    	writer.print(strBuilder);
    	writer.close();
    }
}
