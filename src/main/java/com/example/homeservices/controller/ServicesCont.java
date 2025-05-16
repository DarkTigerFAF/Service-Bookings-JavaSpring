package com.example.homeservices.controller;

import com.example.homeservices.model.Services;
import com.example.homeservices.service.ServiceServ;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
@Validated
public class ServicesCont {
    private final ServiceServ serviceServ;
    public ServicesCont(ServiceServ serviceServ) {
        this.serviceServ = serviceServ;
    }

    @GetMapping("/")
    public List<Services> getAllServices(){
        return serviceServ.getAllServices();
    }

    @PostMapping("/")
    public void createService(@Valid @RequestBody Services service){
        serviceServ.addService(service);
    }

    @PutMapping("/")
    public void updateService(@Valid @RequestBody Services service){
        serviceServ.updateService(service);
    }

    @DeleteMapping("/{id}")
    public void deleteService(@PathVariable int id){
        serviceServ.deleteService(id);
    }
}
