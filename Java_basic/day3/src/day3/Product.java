package day3;

class Product {
	private int code;
	private String productName;
	private double price;
	private int balance;
	
	public void setCode(int c) {
		code = c;
	}
	public int getCode() {
		return code;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
}
