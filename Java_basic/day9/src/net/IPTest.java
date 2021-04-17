package net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPTest {

	public static void main(String[] args) {
		try {
			//3자리.3자리.3자리.3자리
			//0-255.0-255..
			//256*256*256*256
			InetAddress myip = null;		
			myip = InetAddress.getLocalHost();
			System.out.println(myip.getHostAddress());
			
			InetAddress[] ips = InetAddress.getAllByName("www.multicampus.co.kr");
			for(InetAddress one : ips) {
				System.out.println(one.getHostAddress());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		

	}

}
