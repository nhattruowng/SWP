package com.example.booking88be.repository;

import com.example.booking88be.entity.BookingDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IBookingDetailRepository extends JpaRepository<BookingDetail, Long> {
}
