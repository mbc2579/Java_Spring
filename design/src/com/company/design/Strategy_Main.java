package com.company.design;

import com.company.design.strategy.*;

public class Strategy_Main {
    public static void main(String[] arge) {
        Encoder encoder = new Encoder();

        // base64전략 생성
        EncodingStrategy base64 = new Base64Strategy();

        // normal전략 생성
        EncodingStrategy normal = new NormalStrategy();

        String message = "hello java";

        encoder.setEncodingStrategy(base64);
        String base64Result = encoder.getMessage(message);
        System.out.println(base64Result);

        encoder.setEncodingStrategy(normal);
        String normalResult = encoder.getMessage(message);
        System.out.println(normalResult);
    
        //append를 사용하여 message 앞에 ABCD를 추가하는 코드
        encoder.setEncodingStrategy(new AppendStrategy());
        String appendResult = encoder.getMessage(message);
        System.out.println(appendResult);

    }
}
