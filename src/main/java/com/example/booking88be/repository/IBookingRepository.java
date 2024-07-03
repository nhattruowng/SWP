package com.example.booking88be.repository;

import com.example.booking88be.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IBookingRepository extends JpaRepository<Booking,Long> {
}
