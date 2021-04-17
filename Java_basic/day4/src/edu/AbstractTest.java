package edu;
abstract class Shape{
	abstract void area();

}
class Rectangle extends Shape{
	int w, h;
	Rectangle(int w, int h){
		this.w = w;
		this.h = h;
	}
	
	void area() {
		System.out.println
		("가로= "+ w + " 이고 세로 = "+ h + " 인 사각형 면적 = "+ w*h);
	}
}
class Circle extends Shape{
	int r;
	final static double pi = 3.14;
	Circle(int r){
		this.r = r;
	}
	void area() {
		System.out.println
		("반지름= "+ r + " 인 원면적 = "+ r*pi);
	}
}
public class AbstractTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle r = new Rectangle(5,8);
		r.area();
		
	}

}
