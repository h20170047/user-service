package com.svj.controller;

import com.svj.dto.UserRequestDTO;
import com.svj.entity.User;
import com.svj.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService service;

    @Value("${server.port}")
    private int port;

    public UserController(UserService service){
        this.service= service;
    }

    @PostMapping
    public User registerNewUser(@RequestBody @Valid UserRequestDTO user){
        return service.addNewUser(user);
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable int userId){
        System.out.println("Request processed from port: "+ port);
        return service.getUser(userId);
    }

    @PutMapping("{userId}/{amount}")
    public User updateUserBalance(@PathVariable int userId, @PathVariable double amount){
        return service.updateAccountStatus(userId, amount);
    }
}
