package io;

import java.io.IOException;
import java.io.InputStream;

public class SystemInTest {
	public static void main(String[] args) {
		System.out.println("키보드 입력을 시작하세요");
		//0이 입력될 때까지 입력
		/*while(true) {
			int result;
			try {
				result = System.in.read();
				System.out.println((char)result);				
				if(result == '\n') break;
				//if(result == '0') break;
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}*/
//		System.in.123read(); // 0-> 48 1->49 A->65 a->97
		try {			
			InputStream is = System.in;
			byte b[] = new byte[100];
			//cnt --> 입력개수
			int cnt = is.read(b); // 키보드 1바이트 입력 b 배열 저장
			String inputString = new String(b, 0, cnt); //1문자 2바이트
			
			System.out.println(inputString);							
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
