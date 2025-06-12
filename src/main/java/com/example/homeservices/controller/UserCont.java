package com.example.homeservices.controller;

import com.example.homeservices.model.Users;
import com.example.homeservices.service.UserService;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Validated
public class UserCont {
    UserService userService;
    public UserCont(UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/")
    public List<Users> getAllUsers(){
        System.out.println("wtffffffffff");
        return userService.getAllUsers();
    }

    @PostMapping("/register")
    public void createUser(@Valid @RequestBody Users user){
        userService.createUser(user);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody Users user){
        return userService.verify(user);
    }
}
