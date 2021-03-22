
class Book {
	String isbn;
	String title;
	String author;
	String publisher;
	int price;
	String desc;
	
	
	public Book(String isbn, String title, String author, String publisher, int price, String desc) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
	}


	@Override
	public String toString() {		
		return isbn+" | "+title+" | "+author+" | "+publisher+" | "+price+desc;
	}
	
}

class Magazine {
	String isbn;
	String title;
	String author;
	String publisher;
	int year;
	int month;
	int price;
	String desc;
	
	public Magazine(String isbn, String title, String author, String publisher, int year, int month, int price,
			String desc) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.year = year;
		this.month = month;
		this.price = price;
		this.desc = desc;
	}

	@Override
	public String toString() {
		return isbn+" | "+title+" | "+author+" | "
				+publisher+" | "+price+" | "+year+"."+month;
		
	}	

	
}

public class BookTest {
	public static void main(String[] args) {
		String isbn = "21424";
		String title = "Java Pro";
		String author = "김하나";
		String publisher = "Jaen.kr";
		int price = 15000;
		String desc = "기본문법";
		int year;
		int month;
		
		Book b1 = new Book(isbn, title, author, publisher, price, desc);
		System.out.println(b1.toString());
		
		isbn = "35355";
		title = "OOAD 분석, 설계";
		author = "소나무";
		publisher = "Jaen.kr";
		price = 3000;
		desc = "";
		Book b2 = new Book(isbn, title, author, publisher, price, desc);
		System.out.println(b2.toString());
		
		isbn = "35535";
		title = "Java World";
		author = "편집부";
		publisher = "androidjava.com";
		year = 2013;
		month = 2;
		price = 7000;
		desc = "";
		
		Magazine m1 = new Magazine(isbn, title, author, publisher, year, month, price, desc);
		System.out.println(m1.toString());			
				

	}

}
