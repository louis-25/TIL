package day7;

import java.util.HashMap;
import java.util.Set;

public class PhoneMapTest {

	public static void main(String[] args) {
//		s1�迭�� s2�迭�� ���� �����̴�
//		String s1[] = new String[3];
//		s1[0] = "010-1234-5678";
//		s1[1] = "02-3429-0987";
//		s1[2] = "ss@multicampus.com";
//		
//		s1 = new String[30];
//		String s2[] = {"010-1234-5678", "02-3429-0987", "ss@multicampus.com"};
		
		HashMap<String, String[]> phone = 
				new HashMap<String, String[]>();
				
		
		phone.put("�ʵ�ģ��", new String[]{"010-1234-5678", "02-3429-0987", "�ʵ�ģ��@multicampus.com"});
		phone.put("�ʵ�ģ��", new String[]{"010-1223-5678", "02-3429-0987", "���ģ��@multicampus.com"});
		phone.put("ȸ�絿��", new String[]{"010-1234-5678", "02-2432-0987", "ȸ�絿��@multicampus.com"});
		phone.put("ȸ����", new String[]{"010-1234-5678", "02-3559-0987", "ȸ����@multicampus.com"});
		
		System.out.println("�ѿ���ó����="+phone.size());
		
		//ȸ�絿���� ����ó ���� ��ȸ
		String phonelist[] = phone.get("ȸ�絿��");
		for(String one : phonelist) {
			System.out.println(one);
		}
		
		// ������� ����ó ������ȸ
		if(phone.containsKey("�����")) { // phone Map�� �����key���� �ִ���? 
			String phonelist2[] = phone.get("�����");
			for(String one : phonelist) {
				System.out.println(one);
			}
		}
		else {
			System.out.println("������� ����ó�� �����.");
		}
		
		System.out.println();
		//�� ����ó ��� ���� ��ȸ
		Set<String> keys = phone.keySet(); //key�� set�� ���·� �����ش�
		for(String key : keys) {
			phone.get(key + " : "); // key���� ��ȸ�Ͽ� value���� ��ȯ�Ѵ�
			String phonelist1[] = phone.get(key);
			for(String one: phonelist1) {
				System.out.print(one + " | ");
			}
			System.out.println();
		}
		
	}	

}

/*
 * "work dir" = ���� �۾����丮
 * "os" = windows10
 * key = value
 * */
