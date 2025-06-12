package com.example.homeservices.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "booking", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id", "service_id"})
})
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull(message = "User is required")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    @NotNull(message = "Service is required")
    private Services services;

    @NotNull(message = "Date is required")
    private LocalDateTime date;

    private String notes;
}

