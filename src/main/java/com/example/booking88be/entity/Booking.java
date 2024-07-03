package com.example.booking88be.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private long BookingId;

    @ManyToOne
    @JoinColumn(name = "CustomerID")
    private Customer customer;

    @Column(name = "BookingDate")
    private String BookingDate;

    @Column(name = "totalPrice")
    private float totalPrice;

    @Column(name = "status")
    private String status;

    @Column(name = "BookingType")
    private String BookingType;

    @ManyToOne
    @JoinColumn(name = "PaymentId")
    private Payment payment;
    //many to one Promotion

    @OneToMany(mappedBy = "booking",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<BookingDetail> bookingDetails;

    @ManyToOne
    @JoinColumn(name = "promotion_Id")
    private Promotion promotion;
}
