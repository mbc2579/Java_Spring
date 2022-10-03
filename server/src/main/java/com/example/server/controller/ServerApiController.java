package com.example.server.controller;

import com.example.server.dto.Req;
import com.example.server.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Slf4j
@RestController
@RequestMapping("/api/server")
public class ServerApiController {

    // https://openapi.naver.com/v1/search/local.json
    // ?query=%EC%A3%BC%EC%8B%9D
    // &display=10
    // &start=1
    // &sort=random
    @GetMapping("/naver")
    public String naver()  {

        String query = "갈비집";
        String encode = Base64.getEncoder().encodeToString(query.getBytes(StandardCharsets.UTF_8));

        URI uri = UriComponentsBuilder
                .fromUriString("https://openapi.naver.com")
                .path("/v1/search/local.json")
                .queryParam("query", "중국집")
                .queryParam("display", 10)
                .queryParam("start", 1)
                .queryParam("sort", "random")
                .encode(Charset.forName("UTF-8"))
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();

        RequestEntity<Void> req = RequestEntity
                .get(uri)
                .header("X-Naver-Client-Id", "9JMUh2BwEEjDV5yV7DSD")
                .header("X-Naver-Client-Secret", "92EzXvBpsK")
                .build();

        ResponseEntity<String> result = restTemplate.exchange(req, String.class);
        return result.getBody();
    }
}
