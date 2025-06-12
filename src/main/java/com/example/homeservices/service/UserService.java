package com.example.homeservices.service;

import com.example.homeservices.jwt.JWTService;
import com.example.homeservices.model.Users;
import com.example.homeservices.repository.UserRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService {
    private final UserRepo userRepo;

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void createUser(Users appUser) {
        appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
        userRepo.save(appUser);
    }

    public List<Users> getAllUsers() {
        return userRepo.findAll();
    }

    public String verify(@Valid Users user) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
        Users userDB = userRepo.findByEmail(user.getEmail());
        System.out.println(userDB.getRole());
        if(authenticate.isAuthenticated()) {
            return jwtService.generateToken(user.getEmail(), Collections.singletonList(userDB.getRole()));
        }

        return "Failed";
    }
}
