package com.example.homeservices.repository;

import com.example.homeservices.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer> {
    List<Booking> findByUserId(int user_id);
}
