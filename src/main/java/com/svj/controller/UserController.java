package com.svj.controller;

import com.svj.entity.User;
import com.svj.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService service;

    public UserController(UserService service){
        this.service= service;
    }

    @PostMapping
    public User registerNewUser(@RequestBody User user){
        return service.addNewUser(user);
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable int userId){
        return service.getUser(userId);
    }

    @PutMapping("{userId}/{amount}")
    public User updateUserBalance(@PathVariable int userId, @PathVariable double amount){
        return service.updateAccountStatus(userId, amount);
    }
}
