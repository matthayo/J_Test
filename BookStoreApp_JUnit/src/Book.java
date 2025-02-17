
public class Book {
	
	private String title;
	private double price;
	private double weight;
	private double discount;
	
	public Book (String title, double weight, double price) {
		
		this.title = title;
		this.weight = weight;
		this.price = price;
		this.discount = 0;
	}
	
	public String getTitle() {
		return title;
	}
	
	public double getWeight() {
		return weight;
	}

	public double getPrice() {
		return price;
	}
	
	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount/100;
	}
	
	public void adjustPrice(double amount) {
		this.price = this.price + amount;
	}

	public double priceAfterDiscount() {
		return price - (price * discount);
	}

	public boolean equals(Book b) {
		if (b == null) {
			return false; 
		} 
		else {                    
			return b.getTitle().equals(title) && 
					this.weight == b.getWeight()&&
					this.price ==  b.getPrice();
		}
	}

	
	public String toString() {
		return "Book Title:\t\t"+ title + 
				"\n\tWeight:\t\t" + weight + 
				"\n\tPrice:\t\t$" + price + 
				"\n\tDiscount:\t" + (discount * 100) + "%" + "\n";
	
	}
	
}
