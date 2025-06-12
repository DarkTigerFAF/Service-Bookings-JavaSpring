package com.example.homeservices.service;

import com.example.homeservices.model.Booking;
import com.example.homeservices.model.Services;
import com.example.homeservices.model.Users;
import com.example.homeservices.repository.ServicesRepo;
import com.example.homeservices.repository.UserRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService {
    private final ServicesRepo serviceRepo;
    private final BookingService bookingService;
    private final UserRepo userRepo;
    public ServiceService(ServicesRepo serviceRepo, BookingService bookingService, UserRepo userRepo) {
        this.serviceRepo = serviceRepo;
        this.bookingService = bookingService;
        this.userRepo = userRepo;
    }

    public List<Services> getAllServices() {
        return serviceRepo.findAll();
    }

    public void addService(Services service) {
        serviceRepo.save(service);
    }

    public void updateService(Services service) {
        serviceRepo.save(service);
    }

    public void deleteService(int id) {
        serviceRepo.deleteById(id);
    }

    public void bookService(int id) {
        Users user = userRepo.findByEmail(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        Services service = serviceRepo.findById(id).get();

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setServices(service);

        bookingService.addBooking(booking);
    }
}
