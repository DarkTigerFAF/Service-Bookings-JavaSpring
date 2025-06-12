package com.example.homeservices.service;

import com.example.homeservices.model.Booking;
import com.example.homeservices.model.Users;
import com.example.homeservices.repository.BookingRepo;
import com.example.homeservices.repository.UserRepo;
import org.apache.catalina.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class BookingService {
    private final BookingRepo bookingRepo;
    private final UserRepo userRepo;
    public BookingService(BookingRepo bookingRepo, UserRepo userRepo) {
        this.bookingRepo = bookingRepo;
        this.userRepo = userRepo;
    }

    public List<Booking> getAllBookings() {
        String email = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        Users user = userRepo.findByEmail(email);
        return bookingRepo.findByUserId(user.getId());
    }

    public void addBooking(Booking booking) {
        booking.setDate(LocalDateTime.now());
        bookingRepo.save(booking);
    }

    public void updateBooking(Booking booking) {
        bookingRepo.save(booking);
    }

    public List<Booking> getBookingById(int id) {
        return bookingRepo.findByUserId(id);
    }
}
