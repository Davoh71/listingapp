package com.example.listingapp.controller;


import com.example.listingapp.model.User;
import com.example.listingapp.repository.UserRepository;
import com.example.listingapp.servise.UserServise;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    @Autowired()
    private final UserServise userServise;
    @Autowired
    private final UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getUser(){
        return userServise.findAll();
    }
    @GetMapping("/user/{id}")
    public User getById(@PathVariable("id") int id){
            return userServise.findById(id);
    }
    @DeleteMapping("/users/{id}")
    public void delet(@PathVariable int id){
        userServise.delete(id);
    }

    @PostMapping("/users")
    public void create(@RequestBody User user){
        if (user.getId()>0){
            throw new RuntimeException();
        }
        userRepository.save(user);
    }

}
