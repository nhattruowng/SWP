package com.example.booking88be.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Slot")
public class Slot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SLOT_ID")
    private long SlotId;

    @Column(name = "time")
    private int time;

    @Column(name = "price")
    private float Price;

    @Column(name = "status")
    private boolean Status;

    @OneToMany(mappedBy = "Slot",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<CourtSlot> courtSlots;
}
