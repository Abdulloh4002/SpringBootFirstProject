package com.example.springboot1.controller;


import com.example.springboot1.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/user")
public class UserController {

    private List<User> userList = new ArrayList<>();


    @GetMapping("/{id}")
    public User getAllUser(@PathVariable("id") Integer id){

        return userList.stream()
                .filter(x-> Objects.equals(x.getId(),id))
                .toList()
                .get(0);
    }

    @PostMapping
    public String addUser(@RequestBody User user){
        userList.add(user);
        return "User was added to the List successfully";
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable("id") Integer id,@RequestBody User user){
        user.setId(id);
        userList.set(userList.indexOf(userList.stream()
                .filter(x-> Objects.equals(x.getId(),id))
                .toList()
                .get(0)),user);
        return "Object was successfully uodated!";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        userList.remove(userList.indexOf(userList.stream()
                .filter(x-> Objects.equals(x.getId(),id))
                .toList()
                .get(0)));
        return "Object was successfully deleted";
    }

    @PatchMapping
    public List<User> showUsers(){
        return userList;
    }




}
