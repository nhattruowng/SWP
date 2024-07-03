package com.example.booking88be.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Image_id")
    private long imageId;

    @Column(name = "image")
    private byte[] image;

    @ManyToOne
    @JoinColumn(name = " Locations_ID")
    private Location location;
}
