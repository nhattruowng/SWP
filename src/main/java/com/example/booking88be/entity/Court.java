package com.example.booking88be.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Court")
public class Court {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Count_ID")
    private long CountID;
    @Column(name = " name")
    private String Name;

    @ManyToOne
    @JoinColumn(name = "locationID")
    private Location location;

    @OneToMany(mappedBy = "court")
    private List<CourtSlot> slots;
}
