package dev.cfan.rocklifterapi.controller;

import dev.cfan.rocklifterapi.model.User;
import dev.cfan.rocklifterapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/hello")
    public String helloUser(){
        return "Hello User!";
    }

    @GetMapping("")
    public List<User> getAllUsers(){
        System.out.println("Hitting the getAllUsers endpoint. ");
        return userService.getAllUsers();
    }

    @GetMapping("/{username}")
    public User getUserByName(@PathVariable(value = "username") String username){
        return userService.getUserByName(username);
    }
}
