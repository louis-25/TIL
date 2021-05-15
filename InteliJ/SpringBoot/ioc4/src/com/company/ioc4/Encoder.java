package com.company.ioc4;

import java.util.Base64;

public class Encoder{

    private IEncoder iEncoder;

    //생성자에서 인터페이스를 전달받는다
    public Encoder(IEncoder iEncoder){
        this.iEncoder = iEncoder;
    }

    public String encode(String message){
        return iEncoder.encode(message);
    }
}
