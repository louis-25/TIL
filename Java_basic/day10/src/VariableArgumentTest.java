class A{
	int add(int... numbers){
		//numbers 총합
		System.out.println("전달매개변수 갯수="+numbers.length);
		int sum = 0;
		for(int one : numbers) {
			sum += one;
		}
		return sum;
	}
}

public class VariableArgumentTest {
	public static void main(String[] args) {
		A a1 = new A();
		int result = a1.add(1, 2); // 3
		System.out.println("총합=" + result);
		result = a1.add(1, 2, 3, 4, 5, 6, 7,8,9,10); // 55
		System.out.println("총합="+result);
		result = a1.add(1, 22,333);
		System.out.println("총합="+result);
		result = a1.add(12323,32,435, 637,234,0);
		System.out.println("총합="+result);

	}
}
