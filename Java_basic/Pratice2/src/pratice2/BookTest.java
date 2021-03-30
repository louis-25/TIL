package pratice2;

class Book {
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private int price;
	private String desc;
	
	
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
		return isbn+"\t| "+title+"\t| "+author+"\t| "+publisher+"\t| "+price+"\t| "+desc;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}

class Magazine {
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private int year;
	private int month;
	private int price;
	private String desc;
	
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
		return isbn+"\t| "+title+"\t| "+author+"\t| "
				+publisher+"\t| "+price+"\t| "+desc+"\t| "+year+"."+month;
		
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}	
	
	

	
}

public class BookTest {
	public static void main(String[] args) {
		String isbn = "21424";
		String title = "Java Basic";
		String author = "김하나";
		String publisher = "Jaen.kr";
		int price = 15000;
		String desc = "Java 기본문법";
		int year;
		int month;
		
		System.out.println("*********************** 도서목록  **************************");
		Book b1 = new Book(isbn, title, author, publisher, price, desc);
		System.out.println(b1.toString());
		
		isbn = "35355";
		title = "JDBC Pro";
		author = "김철수";
		publisher = "Jaen.kr";
		price = 23000;
		desc = "";
		Book b2 = new Book(isbn, title, author, publisher, price, desc);
		System.out.println(b2.toString());
		
		isbn = "55355";
		title = "Servlet/JSP";
		author = "박자바";
		publisher = "Jaen.kr";
		price = 41000;
		desc = "Model12 기반";
		Book b3 = new Book(isbn, title, author, publisher, price, desc);
		System.out.println(b3.toString());
		
		isbn = "35332";
		title = "Android App";
		author = "홍길동";
		publisher = "Jaen.kr";
		price = 25000;
		desc = "Lightweight Framework";
		Book b4 = new Book(isbn, title, author, publisher, price, desc);
		System.out.println(b4.toString());
		
		isbn = "35355";
		title = "OOAD 분석, 설계";
		author = "소나무";
		publisher = "Jaen.kr";
		price = 30000;
		desc = "";
		Book b5 = new Book(isbn, title, author, publisher, price, desc);
		System.out.println(b5.toString());
				
		System.out.println();
		System.out.println("*********************** 잡지목록  **************************");
		isbn = "35535";
		title = "Java World";
		author = "편집부";
		publisher = "Jaen.kr";
		year = 2013;
		month = 2;
		price = 7000;
		desc = "";
				
		Magazine m1 = new Magazine(isbn, title, author, publisher, year, month, price, desc);
		System.out.println(m1.toString());
		
		isbn = "33434";
		title = "Mobile World";
		author = "편집부";
		publisher = "Jaen.kr";
		year = 2013;
		month = 8;
		price = 8000;
		desc = "";
				
		Magazine m2 = new Magazine(isbn, title, author, publisher, year, month, price, desc);
		System.out.println(m2.toString());	
		
		isbn = "75342";
		title = "Next Web";
		author = "편집부";
		publisher = "Jaen.kr";
		year = 2012;
		month = 10;
		price = 10000;
		desc = "AJAX 소개";
				
		Magazine m3 = new Magazine(isbn, title, author, publisher, year, month, price, desc);
		System.out.println(m3.toString());	
		
		isbn = "76543";
		title = "Architecture";
		author = "편집부";
		publisher = "Jaen.kr";
		year = 2010;
		month = 3;
		price = 5000;
		desc = "java 시스템";
				
		Magazine m4 = new Magazine(isbn, title, author, publisher, year, month, price, desc);
		System.out.println(m4.toString());
		
		isbn = "76534";
		title = "Data Modeling";
		author = "편집부";
		publisher = "Jaen.kr";
		year = 2012;
		month = 12;
		price = 14000;
		desc = "";
				
		Magazine m5 = new Magazine(isbn, title, author, publisher, year, month, price, desc);
		System.out.println(m5.toString());
		
				

	}

}
