package com.example.homeservices.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull(message = "User is required")
    private AppUser user;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    @NotNull(message = "Service is required")
    private Services services;

    @NotBlank(message = "Status is required")
    private String status;

    @NotNull(message = "Date is required")
    private LocalDateTime date;

    @NotBlank(message = "Address is required")
    private String address;

    private String notes;
}

