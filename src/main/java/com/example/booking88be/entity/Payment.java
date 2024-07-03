package com.example.booking88be.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PaymentId")
    private long PaymentId;

    @Column(name = "PaymentStatus")
    private boolean paymentStatus;

    @Column(name = "paymentMethod")
    private String paymentMethod;

    @OneToMany(mappedBy = "payment",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "payment",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Booking> bookings;
}
