package com.example.booking88be.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "court_slots")
public class CourtSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COURSE_SLOT_ID")
    private long COURSE_SLOT_ID;

    @ManyToOne
    @JoinColumn(name = "SLOT_ID")
    private Slot Slot;

    @ManyToOne
    @JoinColumn(name = "BookingDetailsId")
    private BookingDetail bookingDetail;


    @ManyToOne
    @JoinColumn(name = "COURT_ID")
    private Court court;
}
