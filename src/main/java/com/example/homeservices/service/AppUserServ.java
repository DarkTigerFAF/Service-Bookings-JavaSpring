package com.example.homeservices.service;

import com.example.homeservices.model.Users;
import com.example.homeservices.repository.AppUserRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserServ {
    private final AppUserRepo appUserRepo;

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    public AppUserServ(AppUserRepo appUserRepo) {
        this.appUserRepo = appUserRepo;
    }

    public void createUser(Users appUser) {
        appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
        appUserRepo.save(appUser);
    }

    public List<Users> getAllUsers() {
        return appUserRepo.findAll();
    }

    public String verify(@Valid Users user) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword()));

        if(authenticate.isAuthenticated()) {
            return jwtService.generateToken(user.getName());
        }

        return "Failed";
    }
}
