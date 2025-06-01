package com.example.homeservices.repository;

import com.example.homeservices.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepo extends JpaRepository<Users, Integer> {
    Users findByName(String username);
}
