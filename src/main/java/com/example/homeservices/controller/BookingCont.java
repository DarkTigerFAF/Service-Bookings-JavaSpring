package com.example.homeservices.controller;

import com.example.homeservices.model.Booking;
import com.example.homeservices.service.BookingServ;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
@Validated
public class BookingCont {
    BookingServ bookingServ;
    public BookingCont(BookingServ bookingServ) {
        this.bookingServ = bookingServ;
    }

    @GetMapping("/")
    public List<Booking> getBookings() {
        return bookingServ.getAllBookings();
    }

    @PostMapping("/")
    public void addBooking(@Valid @RequestBody Booking booking) {
        bookingServ.addBooking(booking);
    }

    @PutMapping("/")
    public void updateBooking(@Valid @RequestBody Booking booking) {
        bookingServ.updateBooking(booking);
    }

    @GetMapping("/{id}")
    public List<Booking> getBookings(@PathVariable int id) {
        return bookingServ.getBookingById(id);
    }
}
