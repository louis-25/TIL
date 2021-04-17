package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;


public class MemberClient {

	public static void main(String[] args) {
		try {
			Socket s = new Socket("192.168.1.3", 9999); //서버소켓에 연결하기위한 정보
			System.out.println("===서버와 연결중===");
			//서버로 hello server 문자열 전송 = 클라이언트 전송
			
			OutputStream o = s.getOutputStream();
			//o.write(byte1개 / byte[])
			DataOutputStream ds = new DataOutputStream(o);			
//			String data = "hello server";
			Scanner sc = new Scanner(System.in);
			System.out.print("1>회원아이디입력: ");
			String id = sc.next();
			System.out.print("2>암호입력: ");
			String pw = sc.next();
			ds.writeUTF(id); //클라이언트가 서버로 데이터스트림 전송
			ds.writeUTF(pw);
						
			//서버로부터 입력
			InputStream i = s.getInputStream();		
			DataInputStream ds2 = new DataInputStream(i);
			String input_b = ds2.readUTF();
			System.out.println("===서버가 클라이언트로 데이터전송=="+input_b);
			
			s.close();
			System.out.println("===서버와 연결종료===");
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
