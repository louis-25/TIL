package day6;

class Book{
	private String title;
	private int price;
	
	Book(){
		
	}
	
	Book(String title, int price){
		this.title = title;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}

class BookMgr{
	Book[] booklist;
	BookMgr(Book[] booklist){
		this.booklist = booklist;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		int total_price = 0;
		for(Book l : booklist) {
			System.out.println(String.format("%-25s", l.getTitle())+"|"+l.getPrice());
			total_price+=l.getPrice();
		}
		
		return "전체 책 가격의 합 : " +total_price;
	}
}
public class BookStrore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book booklist[] = new Book[5];

		Book book1 = new Book("Java Program", 25000);
		Book book2 = new Book("JSP Program", 15000);
		Book book3 = new Book("SQL Fundamentals", 30000);
		Book book4 = new Book("JDBC Program", 28000);
		Book book5 = new Book();
		book5.setTitle("Spring Program");
		book5.setPrice(34000);
		booklist[0] = book1;
		booklist[1] = book2;
		booklist[2] = book3;
		booklist[3] = book4;
		booklist[4] = book5;
		
		BookMgr mgr = new BookMgr(booklist);
		System.out.println("=== 책 목록  정보 ===");
		System.out.println(mgr);
	}

}
