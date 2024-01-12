package com.example.springboot1.controller;


//import
import com.example.springboot1.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public User getAllUser(){
        return new User("imron", 15);
    }
}
