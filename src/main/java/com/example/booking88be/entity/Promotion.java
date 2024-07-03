package com.example.booking88be.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Promotion")
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "promotion_Id")
    private long promotionId;
    @Column(name = "discount")
    private double discount;
    @Column(name = "startDate")
    private Date startDate;
    @Column(name = "endDate")
    private Date endDate;

    @OneToMany(mappedBy = "Promotion",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<Booking> bookings;

    @ManyToOne
    @JoinColumn(name = "Locations_Id")
    private Location location;
}
