package com.example.ioc;

public class Encoder{

    private com.example.ioc.IEncoder iEncoder;

    //생성자에서 인터페이스를 전달받는다
    public Encoder(com.example.ioc.IEncoder iEncoder){
        this.iEncoder = iEncoder;
    }

    public String encode(String message){
        return iEncoder.encode(message);
    }
}
