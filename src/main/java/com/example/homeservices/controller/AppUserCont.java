package com.example.homeservices.controller;

import com.example.homeservices.model.AppUser;
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
    public List<AppUser> getAllUsers(){
        return appUserServ.getAllUsers();
    }

    @PostMapping("/")
    public void createUser(@Valid @RequestBody AppUser user){
        appUserServ.createUser(user);
    }
}
