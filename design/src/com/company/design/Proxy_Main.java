package com.company.design;

import com.company.design.aop.AopBrowser;
import com.company.design.proxy.Browser;
import com.company.design.proxy.BrowserProxy;
import com.company.design.proxy.IBrowser;

import java.util.concurrent.atomic.AtomicLong;

public class Proxy_Main {
    public static void main(String[] args) {


        //프록시 패턴
        Browser browser = new Browser("www.naver.com");
        browser.show();
        browser.show();
        browser.show();
        browser.show();



        /*
        IBrowser browser = new BrowserProxy("www.naver.com");
        browser.show();
        browser.show();
        browser.show();
        browser.show();



        //프록시 패턴에 속하는 aop패턴 예제 람다식 사용
        //시간 aop패턴을 사용하여 현재 시스템이 어디서 오래 걸리고 있는지 어떤 메소드가 오래걸려서 우리의 서버가 느린 상태인지 발견하는데 많이 사용
        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();
        
        //람다식 표현 방법
        IBrowser aopBrowser = new AopBrowser("www.naver.com",
                ()->{
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                ()->{
                    long now = System.currentTimeMillis();
                    end.set(now - start.get());
                }
        );

        // 처음 호출할 때는 약 1.5초 걸리는데 두번 째 호출할 때는 캐쉬를 사용하기 때문에 0초가 걸린다.
        aopBrowser.show();
        System.out.println("loading time : "+end.get());

        aopBrowser.show();
        System.out.println("loading time : "+end.get());

         */
    }
}
