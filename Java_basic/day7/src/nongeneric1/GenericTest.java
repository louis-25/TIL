package nongeneric1;

class Apple {
	String origin = "�뱸";
}
class Paper {
	String size = "A4";
}
class Box<T>{
	T o;
	Box(T o) {
		this.o = o;
	}
	public T getO() {
		return o;
	}
	public void setO(T o) {
		this.o = o;
	}
	
}
public class GenericTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Apple a = new Apple();
		Paper p = new Paper();
		//<Apple> <Paper> ���׸� Ÿ�Ի��
		Box<Apple> appleBox = new Box<Apple>(a);
		Box<Paper> paperBox = new Box<Paper>(p);
		//���׸� Ÿ���� ����ϸ� �Ʒ��Ͱ��� �ڵ尡 ����������
		System.out.println(appleBox.getO().origin);
		System.out.println(paperBox.getO().size);
		
		//���׸� Ÿ���� ������� �ʴ°��
//		if(appleBox.getO() instanceof Apple) { //appleBox�� Apple��ü�ΰ�?
//			System.out.println(((Apple)(appleBox.getO())).origin);
//		}
//		if(paperBox.getO() instanceof Paper) { //paperBox�� Paper��ü�ΰ�?
//			System.out.println(((Paper)(paperBox.getO())).size);
//		}
	}

}
