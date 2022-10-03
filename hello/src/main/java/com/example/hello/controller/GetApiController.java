package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    // 첫번 째 GetMapping 방법
    @GetMapping(path = "/hello") // http://localhost:9090/api/get/hello로 매핑 후 동작
    public String hello() {
        return "get Hello";
    }

    // @RequestMapping("/hi") 이런식으로 사용을 하면 get / post / put / delete 등 모든 메소드가 동작하게 된다.

    // 이러한 방식은 예전에 사용되던 mapping방법이고 위의 주석 코드와 아래 코드를 둘다 합친것이 GetMapping이다.
    // get만 불러오고 싶을 경우에는 이렇게 작성해야 하고 주소는 http://localhost:9090/api/get/hi로 지정됨.
    @RequestMapping(path = "/hi", method = RequestMethod.GET)
    public String hi() {
        return "hi";
    }

    /*
     http://localhost:9090/api/get/path-variable/{name} 이렇게 작성하면 name은 계속 변화를 하기 때문에 아래와 같이 계속 추가를 할 수 없다.
     http://localhost:9090/api/get/path-variable/{spring}
     http://localhost:9090/api/get/path-variable/{java}와 같이 변화하는 값이 들어올 때 마다 주소를 계속 만들면서 메소드를 추가할 수 없으므로

    @GetMapping("/path-variable/{name}") // path-variable뒤에 /{}를 붙여주고 그 안에 무엇을 받을건지 작성해준다.
    // "/path-variable/{name}"의 name과 아래 코드의 @PathVariable String name의 변수명과 같아야 한다.
    // 그러므로 변수명이 String 타입의 name로 일치하게 되는것.
    public String pathVariable(@PathVariable String name) {
        System.out.println("PathVariable : "+name);
        return name;
     */


    // 여기서 개발을 하다가 /path-variable/{name}에다가 name을 해놨는데 변수에는 이름을 다르게 설정해야 할 때는
    // 변수 이름을 다른걸로 선언하고 @PathVariable(name = "name")와 같이 @PathVariable 뒤에 주소에 적힌 이름과 동일하게 적어주면 된다.
    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable(name = "name") String pathName) {
        System.out.println("PathVariable : "+pathName);
        return pathName;
    }

    // http://localhost:9090/api/get/query-param?user=steve&email=steve@gmail.com&age=23
    // 첫번째 방법
    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam) {

        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach( entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey()+" = "+entry.getValue()+"\n");
        });


        return sb.toString();
    }

    // 두번째 방법
    @GetMapping("query-param02")
    public String queryParam02(
        @RequestParam String name,
        @RequestParam String email,
        @RequestParam int age
    ){
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name+" "+email+" "+age;
    }
    
    // 3번째 방법 현업에서 제일 많이 사용하는 방법
    // dto라는 패키지를 생성하고 원하는 값의 변수를 선언 후 getter, setter를 만들어준다.
    @GetMapping("query-param03")
    public String queryParam03(UserRequest userRequest){

        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }

}
