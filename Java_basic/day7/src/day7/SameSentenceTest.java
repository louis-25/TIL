package day7;

import java.util.ArrayList;

//�ǽ�

// import �ڸ�
class SameSentence{
	String[] compare(ArrayList<String> list1, ArrayList<String> list2){
		String[] result = new String[4];	
		ArrayList<String> resultList = new ArrayList<String>();
		
		int len1 = list1.size();
		int len2 = list2.size();
		
		//�����Ͻÿ�.
		/* list1, list2 ������ ���� ��
		 * �ٸ���  "�ּ� (�������� ����)3��, �ִ� (ū�� ����)4���� ����Ʈ�Դϴ�"  ��  result   �迭�� �־ ����
		 * ������ 2�� ArrayList  �� �ε������� ���ڿ� ���� ���ϰ� ���� ���ڿ� ���� ������  result  �迭�� �־ ����
		 * */
		if(len1 > len2) {
//			result[0] = "�ּ�" + len2 + " ��, �ִ�" + len1 +" ���� ����Ʈ�Դϴ�.";
			resultList.add("�ּ�" + len2 + " ��, �ִ�" + len1 +" ���� ����Ʈ�Դϴ�.");
		}else if (len1 < len2) {
			resultList.add("�ּ�" + len1 + " ��, �ִ�" + len2 +" ���� ����Ʈ�Դϴ�.");
		}else { // len1 == len2
			for(int i = 0; i < len1; i++) {
				if(list1.get(i).equals(list2.get(i))) {
//					result[i] = list1.get(i);
					resultList.add(list1.get(i));
				}
			}
		}		
				
		result = new String[resultList.size()]; //resultList�� ũ�⸸ŭ �迭�� �����
		//ArrayList �����͸� �迭 ���� �޼ҵ�
		result = resultList.toArray(result); //resultList�� �����͸� result�迭�� ����
		return result;//
	}
}
public class SameSentenceTest {
public static void main(String[] args) {
	ArrayList<String> list1 = new ArrayList<String>();
	list1.add("�ڹٴ� ��ü���� ����Դϴ�");
	list1.add("�츮�� ��Ƽķ�۽����� �ڹٸ� ���� ���Դϴ�");
	list1.add("������ �÷��� �����ӿ�ũ�� �����! ");
	list1.add("����, ����°� ��Ʈ��ũ�� ��� �����Դϴ� ");
	
	ArrayList<String> list2 = new ArrayList<String>();
	list2.add("�ڹٴ� ��ü���� ����Դϴ�");
	list2.add("�츮�� multicampus���� �ڹٸ� ���� ���Դϴ�");
	list2.add("������ �÷��� �����ӿ�ũ�� �����! ");
	list2.add("����°� ��Ʈ��ũ�� ��� �����Դϴ� ");
	
	ArrayList<String> list3 = new ArrayList<String>();
	list3.add("�ڹٴ� ��ü���� ����Դϴ�");
	list3.add("�츮�� multi���� �ڹٸ� ���� ���Դϴ�");
	list3.add("������ �÷��� �����ӿ�ũ�� �����! ");
	
	SameSentence ss = new SameSentence();
	String[] a = ss.compare(list1, list2);//list1, list2���� ���� ���븸 ���
	for(String one: a) {
//		if(one != null) System.out.println(one);
		System.out.println(one);
	}
	
	String[] b = ss.compare(list1, list3);//�ּ� 3��, �ִ� 4���� ����Ʈ�Դϴ� ���	
	for(String one: b) {
//		if(one != null) System.out.println(one);
		System.out.println(one);
	}
}
}
