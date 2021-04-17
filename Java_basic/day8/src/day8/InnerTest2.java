package day8;

class Outer2 { 
   int outervar = 10; // 외부클래스 non-static 멤버변수
   static int outervar2 = 20; //외부클래스 static 멤버변수
   String name = "Outer2";
   
   class Inner{ //non-static(=인스턴스) 멤버중첩클래스
      String name = "Inner";
      void m() {
         String name = "m메소드";
         System.out.println("중첩클래스 메소드 실행");
         System.out.println(outervar);
         System.out.println(outervar2);
         System.out.println(name);
         System.out.println(this.name);
         System.out.println(Outer2.this.name);
      }
   }//inner end
   static class Inner2{ //static 멤버중첩클래스.
      //static 여부에 띠라 방식이 달라진다. 
      void m2() {
         System.out.println("중첩클래스 메소드 실행2");
         //System.out.println(outervar); //사용불가 이유. static된 변수만 이용해라!
         System.out.println(outervar2);
      }
   }
   //아래는 지연변수 활용. 
   void test() { //메소드 호출 test 안에서 할 것. 
      //지역중첩클래스 
      class Inner3 {
         void m3() {
            System.out.println("중첩클래스 메소드 실행3");
         }
      }
      new Inner3().m3(); // test메소드만 사용가능하도록 함. test 메소드 안에 있어야 함. 
   }//test end 
}

public class InnerTest2 {
//1> main 실행 이전 static( 변수, 내부 클래스 , 메소드) 메모리에 저장 - 미리 생성됨
//2> new Outer2() 실행 non-static (변수, 내부클래스, 메소드) 메모리 저장 - 공유 
   public static void main(String[] args) {
      //Outer o = new Outer(); //외부 클래스 객체 먼저 만들고
      Outer2.Inner i = new Outer2(). new Inner(); //내부 클래스 객체를 만들어라!
      i.m();
      
      Outer2.Inner2 i2 = new Outer2.Inner2(); //static이라면 outer 클래스 객체를 만들지 않는다. 바로 inner 객체만 만든다.
      i2.m2();
      
      Outer2 o = new Outer2();
      o.test();
      
   }

}