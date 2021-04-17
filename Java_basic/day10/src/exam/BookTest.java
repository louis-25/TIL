package exam;

class Book {
	   String isbn;
	   String title;
	   String author;
	   String publisher;
	   int price;
	   String desc;

      public String toString() {
          return  isbn +" | "+ title +" |"+ author +" |"+ publisher +" |"+ price + " " + desc;
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
      String isbn;
      String title;
      String author;
      String publisher;
      int year;
      int month;
      int price;
      String desc;
      
      public String toString() {
         return  isbn +" | "+ title +" |"+ author +" |"+ publisher +" | androidjava.com |"+ price + " |" + desc + year +"."+ month ;
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
           Book b = new Book();
           //변수을 선언해서 값을 세팅하고 매개변수에 넣으면 된다. 
           b.isbn = "21424";
           b.title = "Java Pro";
           b.author = "김하나";
           b.publisher = "Jaen.kr";
           b.price= 15000;
           b.desc = "기본문법";
           
           Book c = new Book();
           c.isbn = "35355";
           c.title = "OOAD 분석, 설계";
           c.author = "소나무";
           c.publisher = b.publisher;
           c.price= 30000;
           c.desc = "";
           
           System.out.println("************************ 도서목록 ***********************");
           System.out.println(b.toString());
           System.out.println(c.toString());
  
           Magazine m = new Magazine();
           m.isbn = "35355";
           m.title = "Java World";
           m.author = "";
           m.publisher = "편집부";
           m.year = 2013;
           m.month = 2;
           m.price= 7000;
           m.desc = "";
  
           /* 35535 | Java World     편집부 | androidjava.com | 7000 | 2013.2 */
           System.out.println(m.toString());      
   }
}

