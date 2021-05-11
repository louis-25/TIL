package com.company;

import com.company.singleton.AClass;
import com.company.singleton.BClass;
import com.company.singleton.SocketClient;

public class Main {

    public static void main(String[] args) {
	// write your code here
        AClass aClass = new AClass();
        BClass bClass = new BClass();

        SocketClient aClient = aClass.getSocketClient();
        SocketClient bClient = aClass.getSocketClient();

        System.out.println("두개의 객체가 동일한가?");
        System.out.println(aClient.equals(bClient));

    }
}
