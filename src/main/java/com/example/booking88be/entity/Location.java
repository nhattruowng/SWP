package com.example.booking88be.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.util.List;

@Data
@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private long locationId;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "Address")
    private String address;
    @Column(name = "hotline")
    private String hotline;
    @Column(name = "opening_time")
    private float openTime;
    @Column(name = "closing_time")
    private float closeTime;
    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "locationOwnerID")
    private LocationOwner locationOwner;

    @OneToMany(mappedBy = "location",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Court> courts;


    @OneToMany(mappedBy = "location",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Image> images;

    @OneToMany(mappedBy = "location",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Promotion> promotions;

}
