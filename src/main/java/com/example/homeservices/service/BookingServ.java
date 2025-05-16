package com.example.homeservices.service;

import com.example.homeservices.model.Booking;
import com.example.homeservices.repository.BookingRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServ {
    private final BookingRepo bookingRepo;
    public BookingServ(BookingRepo bookingRepo) {
        this.bookingRepo = bookingRepo;
    }

    public List<Booking> getAllBookings() {
        return bookingRepo.findAll();
    }

    public void addBooking(Booking booking) {
        bookingRepo.save(booking);
    }

    public void updateBooking(Booking booking) {
        bookingRepo.save(booking);
    }

    public List<Booking> getBookingById(int id) {
        return bookingRepo.findByUser_Id(id);
    }
}
