
public class Invoice2 {
	
	private String customer;
	private Book2 books[];
	
	private static double tax;
	
	private final int MAX_NUMBER_OF_BOOKS = 3;
	private int numberOfBooks = 0;
	private static int numberOfInvoices = 0;
	
	public Invoice2(String customer) {
		
		this.customer = customer;
		books = new Book2[MAX_NUMBER_OF_BOOKS];
		numberOfInvoices++;
	}

	public double getTotal() {

		double totalCost = 0;
		
		if(numberOfBooks == 0)
			return totalCost;
		
		for(int i = 0; i < numberOfBooks; i++) {
			totalCost += books[i].getPrice();
		}
		return totalCost;
	} 
	
	public double getDiscountedTotal() {

		double totalCostAfterDiscount = 0;
		if(numberOfBooks == 0)
			return totalCostAfterDiscount;
		
		for(int i = 0; i < numberOfBooks; i++) 
			totalCostAfterDiscount += books[i].priceAfterDiscount();
		
		return totalCostAfterDiscount;
	} 
	
	public double getTotalWeight() {

		double totalWeight = 0;
		if(numberOfBooks == 0)
			return totalWeight;
		
		for(int i = 0; i < numberOfBooks;i++) {

			totalWeight += books[i].getWeight();
		}
		return totalWeight;
	}
	
	public static int getNumberOfInvoices() {
		return numberOfInvoices;		
	}
	
	public void addBook(String title, double price, double weight) throws ArrayIndexOutOfBoundsException{
		
		if(numberOfBooks >= MAX_NUMBER_OF_BOOKS)
			throw new ArrayIndexOutOfBoundsException("Max number exceeded!");
		else 
			books[numberOfBooks++] = new Book2(title, price, weight);
	}

	public void adjustPrice(int bookNum, double priceAdjustment) throws ArrayIndexOutOfBoundsException {
		
		if(bookNum < 0 || bookNum >= MAX_NUMBER_OF_BOOKS)
			throw new ArrayIndexOutOfBoundsException("Price cannot be adjusted!");
		else {
			books[bookNum].adjustPrice(priceAdjustment);			
		}
	}
	
	public void applyDiscount(int bookNum, double discount) throws ArrayIndexOutOfBoundsException {
	
		if(bookNum < 0 || bookNum >= MAX_NUMBER_OF_BOOKS)
			throw new ArrayIndexOutOfBoundsException("Discount Cannot be applied");
		else {
			books[bookNum].setDiscount(discount);			
		}
	}

	public static double calculateTax(double cost, double taxRate) {
		tax = (cost*taxRate)/100;
		return tax;
	}
	
	public String toString() {  
		
		StringBuilder builder = new StringBuilder();
		builder.append("\n================= INVOICE ==================\n");
		builder.append("Customer Name: ");
		builder.append(customer).append("\n");
		
		for(int i = 0; i < MAX_NUMBER_OF_BOOKS;i++) {
			if(this.books[i] != null) {
				builder.append(this.books[i].toString()).append(" ");
			}
		}
		
		builder.append("\n");         
		builder.append("Total Weight: ");         
		builder.append(getTotalWeight());         
		builder.append("\n");         
		builder.append("Invoice Total (before discount): $");        
		builder.append(getTotal());         
		builder.append("\n");         
		builder.append("Invoice Total (after discount): $");         
		builder.append(getDiscountedTotal()).append("\n");                  
		builder.append("Tax: $").append("");   
		builder.append(calculateTax(getTotal(), 4.5));  
		builder.append("\n\n");         
		builder.append("Overall Cost: $").append(getDiscountedTotal() + tax);
		builder.append("\n============= END OF INVOICE ===============\n");

		return builder.toString(); 

	} 
}
