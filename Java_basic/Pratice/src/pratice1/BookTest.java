package pratice1;

class Book {
	String isbn;
	String title;
	String author;
	String publisher;
	int price;
	String desc;		

	@Override
	public String toString() {		
		return isbn+"\t| "+title+"\t| "+author+"\t| "+publisher+"\t| "+price+desc;
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

	@Override
	public String toString() {
		return isbn+"\t| "+title+"\t| "+author+"\t| "
				+publisher+"\t| "+price+"\t| "+year+"."+month;		
	}		
}

public class BookTest {
	public static void main(String[] args) {		
				
		Book b1 = new Book();
		b1.isbn = "21424";
		b1.title = "Java Pro";
		b1.author = "김하나";
		b1.publisher = "Jaen.kr";
		b1.price = 15000;
		b1.desc = "기본문법";		
		
		Book b2 = new Book();
		b2.isbn = "35355";
		b2.title = "OOAD 분석, 설계";
		b2.author = "소나무";
		b2.publisher = "Jaen.kr";
		b2.price = 30000;
		b2.desc = "";					
		
		Magazine m1 = new Magazine();
		m1.isbn = "35535";
		m1.title = "Java World";
		m1.author = "편집부";
		m1.publisher = "androidjava.com";
		m1.year = 2013;
		m1.month = 2;
		m1.price = 7000;
		m1.desc = "";
		
		System.out.println("*********************** 도서목록  **************************");
		System.out.println(b1.toString());
		System.out.println(b2.toString());
		System.out.println(m1.toString());
				

	}

}
