package com.example.homeservices.repository;

import com.example.homeservices.model.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesRepo extends JpaRepository<Services, Integer> {
}
