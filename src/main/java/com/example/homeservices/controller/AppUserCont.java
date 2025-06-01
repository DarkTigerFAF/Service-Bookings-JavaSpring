package com.example.homeservices.controller;

import com.example.homeservices.model.Users;
import com.example.homeservices.service.AppUserServ;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Validated
public class AppUserCont {
    AppUserServ appUserServ;
    public AppUserCont(AppUserServ appUserServ) {
        this.appUserServ = appUserServ;
    }

    @GetMapping("/")
    public List<Users> getAllUsers(){
        return appUserServ.getAllUsers();
    }

    @PostMapping("/register")
    public void createUser(@Valid @RequestBody Users user){
        appUserServ.createUser(user);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody Users user){
        return appUserServ.verify(user);
    }
}
