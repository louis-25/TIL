package test;

class Book {
	String isbn;
	String title;
	
	Book() { // 생성자 -> Class 이름이 같다
		System.out.println("생성자1번");
	}
	
	Book(String a, String b) { // 생성자 2번째
		this.isbn = a;
		this.title = b;
		System.out.println(a + " | " + b);
	}

	@Override
	public String toString() {
		return isbn + " | " +title;
	}	
}

public class BookTest2 {
	public static void main(String[] args) {
		Book b = new Book();
		
		String isbn = "12345";
		String title = "java";
		
		Book b2 = new Book(isbn, title);
		System.out.println(b2);
		
	}
}
