package com.example.reponse.controller;

import com.example.reponse.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    // TEXT
    @GetMapping("/text")
    public String text(@RequestParam String account) {
        return account;
    }

    //JSON
    @PostMapping("/json")
    public User json(@RequestBody User user) {
        return user;
    }

    @PutMapping("/put")
    public ResponseEntity<User> put(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
