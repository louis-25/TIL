package com.company.singleton;

public class SocketClient {
    private static SocketClient socketClient = null;

    private SocketClient() { //기본생성자는 접근못하게 막아둔다

    }

    public static SocketClient getInstance(){
        //최초 한번만 생성되게함
        if(socketClient == null) {
            socketClient = new SocketClient();
        }
        return socketClient;
    }

    public void connect(){
        System.out.println("connect");
    }
}
