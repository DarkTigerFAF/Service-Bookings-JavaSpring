package com.example.homeservices.controller;

import com.example.homeservices.model.Booking;
import com.example.homeservices.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
@Validated
public class BookingCont {
    BookingService bookingService;
    public BookingCont(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/")
    public List<Booking> getBookings() {
        return bookingService.getAllBookings();
    }

//    @PostMapping("/")
//    public void addBooking(@Valid @RequestBody Booking booking) {
//        bookingService.addBooking(booking);
//    }
//
//    @PutMapping("/")
//    public void updateBooking(@Valid @RequestBody Booking booking) {
//        bookingService.updateBooking(booking);
//    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public List<Booking> getBookings(@PathVariable int id) {
        return bookingService.getBookingById(id);
    }
}
