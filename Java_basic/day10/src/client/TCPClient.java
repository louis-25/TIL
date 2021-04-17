package client;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
	public static void main(String[] args) {
		try {
			Socket s = new Socket("192.168.1.3", 9999); //서버소켓에 연결하기위한 정보
			System.out.println("===서버와 연결중===");
			//서버로 hello server 문자열 전송 = 클라이언트 전송
			OutputStream o = s.getOutputStream();
			String data = "hello server";
			//String --> byte[] 변경
			byte[] data_byte = data.getBytes();	//String -> byte[]					
			o.write(data_byte); //바이트밖에 전송못함 -> 서버로 전송
			
			//서버로부터 입력
			InputStream i = s.getInputStream();		
			//방법1
//			byte b[] = new byte[100];
//			i.read(b); // 읽은내용을 byte배열 b에 넣는다
//			//byte[] --> String
//			String input_b = new String(b);
			
			//방법2
			Scanner sc = new Scanner(i);
			String input_b = sc.nextLine();
			System.out.println("===서버가 클라이언트로 전송 데이터==="+input_b);
			
			s.close();
			System.out.println("===서버와 연결종료===");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
