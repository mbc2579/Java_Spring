package com.company.design;

import com.company.design.decorator.*;

public class Decorator_Main {
    public static void main(String[] arge) {
        // 등급에 따라 가격이 달라지는 예제
        ICar audi = new Audi(1000);
        audi.showPrice();

        // a3
        ICar audi3 = new A3(audi, "A3");
        audi3.showPrice();

        // a4
        ICar audi4 = new A4(audi, "A4");
        audi4.showPrice();

        // a5
        ICar audi5 = new A5(audi, "A5");
        audi5.showPrice();

    }
}
