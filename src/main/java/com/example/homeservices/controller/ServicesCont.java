package com.example.homeservices.controller;

import com.example.homeservices.model.Services;
import com.example.homeservices.service.ServiceService;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
@Validated
public class ServicesCont {
    private final ServiceService serviceService;
    public ServicesCont(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping("/")
    public List<Services> getAllServices(){
        return serviceService.getAllServices();
    }

    @PostMapping("/book/{id}")
    public void bookService(@PathVariable int id){
        serviceService.bookService(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/")
    public void createService(@Valid @RequestBody Services service){
        serviceService.addService(service);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/")
    public void updateService(@Valid @RequestBody Services service){
        serviceService.updateService(service);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteService(@PathVariable int id){
        serviceService.deleteService(id);
    }
}
