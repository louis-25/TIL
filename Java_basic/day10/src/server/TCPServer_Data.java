package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServer_Data {
	public static void main(String[] args) {
		//ServerSocket port번호 = 서버프로그램 식별번호 = 2^16 = 0-65535
		//0-1024이내 ftp telnet http 프로토콜 포트예약
		//1025 - 5000 이내 권고 사항 os 사용 소지
		try {
			ServerSocket ss = new ServerSocket(9999); //서버 시작 연결 대기중
			System.out.println("====서버 시작 대기중====");
			while(true) {
				Socket s = ss.accept(); //연결 승인 Socket 생성(-연결점)
				System.out.println("====클라이언트와 연결중====");
				InputStream i = s.getInputStream();
				DataInputStream ds = new DataInputStream(i);
				String input_b = ds.readUTF(); //클라이언트로부터 스트림을 읽어온다							
				System.out.println("===클라이언트가 서버로 전송 데이터==="+input_b);							
											
				//클라이언트로 hello client 문자열 전송 = 서버가 출력
				OutputStream o = s.getOutputStream();
				DataOutputStream ds2 = new DataOutputStream(o);
				String data = "hello client";
				ds2.writeUTF(data); //클라이언트로 데이터스트림 전송
				System.out.println("===서버가 클라이언트로 전송 데이터="+data);
				
				s.close();
				System.out.println("====클라이언트와 연결종료====");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
	}
}
