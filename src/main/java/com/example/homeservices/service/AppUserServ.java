package com.example.homeservices.service;

import com.example.homeservices.model.AppUser;
import com.example.homeservices.repository.AppUserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserServ {
    private final AppUserRepo appUserRepo;

    public AppUserServ(AppUserRepo appUserRepo) {
        this.appUserRepo = appUserRepo;
    }

    public void createUser(AppUser appUser) {
        appUserRepo.save(appUser);
    }

    public List<AppUser> getAllUsers() {
        return appUserRepo.findAll();
    }
}
