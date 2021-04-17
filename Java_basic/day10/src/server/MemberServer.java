package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberServer {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(9999); //서버 시작 연결 대기중
			System.out.println("====서버 시작 대기중====");
//			ArrayList<String> ids = new ArrayList<String>(5);
			String ids[] = {"java", "jsp", "spring"};
			while(true) {
				Socket s = ss.accept(); //연결 승인 Socket 생성(-연결점)
				System.out.println("====클라이언트와 연결중====");
				InputStream i = s.getInputStream();
				DataInputStream ds = new DataInputStream(i);
				
				//클라이언트로 hello client 문자열 전송 = 서버가 출력
				OutputStream o = s.getOutputStream();
				DataOutputStream ds2 = new DataOutputStream(o);
				
				String input_b = ds.readUTF();
				boolean check_id = false;
				
				for(String one:ids) {
					System.out.println("one="+one);
					System.out.println("input_b="+input_b);
					if(one.equals(input_b)) {						
						check_id = true;
						break;
					}					
				}								
						
				
				if(check_id == true) {
					System.out.println("다른 아이디를 사용하세요");
					ds2.writeUTF("다른 아이디를 사용하세요");
				}
				else {
					ds2.writeUTF(input_b+"는 사용 가능합니다");
					System.out.println(input_b+"는 사용 가능합니다");
				}
				s.close();
				
				System.out.println("====클라이언트와 연결종료====");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

}
