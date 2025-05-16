package com.example.homeservices.service;

import com.example.homeservices.model.Services;
import com.example.homeservices.repository.ServicesRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServ {
    private final ServicesRepo serviceRepo;
    public ServiceServ(ServicesRepo serviceRepo) {
        this.serviceRepo = serviceRepo;
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
}
