package com.company;

import com.company.adapter.*;

public class Main {

    public static void main(String[] args) {
        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        /*
        cleaner와 airConditioner는 220v라 110v랑은 호환이안된다
        하지만 110v로 변환시켜주는 adapter를 통해 타입을 바꿔줄 수 있다
        */
        Cleaner cleaner = new Cleaner();
        Electronic110V adapter = new SocketAdapter(cleaner);
        connect(adapter);

        AirConditioner airConditioner = new AirConditioner();
        Electronic110V airAdapter = new SocketAdapter(airConditioner);
        connect(airAdapter);
    }
    // 콘센트
    public static void connect(Electronic110V electronic110V){
        electronic110V.powerOn();
    }
}

