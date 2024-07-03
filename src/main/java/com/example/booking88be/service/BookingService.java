package com.example.booking88be.service;

import com.example.booking88be.entity.*;
import com.example.booking88be.iservice.*;
import com.example.booking88be.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Component
public class BookingService implements IBooking {

    @Autowired
    private IBookingRepository bookingRepository;


    @Override
    public Booking addBooking(Booking booking) {
        return booking!=null ? bookingRepository.save(booking) : null;
    }

    @Override
    @Transactional
    public void deleteBooking(long id) {
            bookingRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Booking updateBooking(long id, Booking booking) {
        return bookingRepository.findById(id).map(b -> {
            b.setCustomer(booking.getCustomer());
            b.setBookingDate(booking.getBookingDate());
            b.setBookingType(booking.getBookingType());
            b.setBookingDetails(booking.getBookingDetails());
            b.setPayment(booking.getPayment());
            b.setPromotion(booking.getPromotion());
            b.setStatus(booking.getStatus());
            b.setTotalPrice(booking.getTotalPrice());
            return bookingRepository.save(b);
        }).orElse(null);
    }

    @Override
    public Booking findBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}
