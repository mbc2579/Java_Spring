package com.company.design;

import com.company.design.adapter.*;

public class Adapter_Main {
        public static void main(String[] args) {

        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        Cleaner cleaner = new Cleaner();
        Electronic110V adapter = new SocketAdapter(cleaner);
        connect(adapter);

        AirConditioner airConditioner = new AirConditioner();
        Electronic110V airAdapter = new SocketAdapter(airConditioner);
        connect(airAdapter);

    }

    //어뎁터 예제
    //콘센트
    public static void connect(Electronic110V electronic110V) {
        electronic110V.powerOn();
    }
}
