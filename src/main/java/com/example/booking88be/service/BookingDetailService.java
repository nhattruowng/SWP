package com.example.booking88be.service;

import com.example.booking88be.entity.BookingDetail;
import com.example.booking88be.iservice.IBookingDetail;
import com.example.booking88be.repository.IBookingDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class BookingDetailService implements IBookingDetail {

    @Autowired
    private IBookingDetailRepository bookingDetailRepository;


    @Override
    public BookingDetail addBooking(BookingDetail bookingDetail) {
        return bookingDetail != null ? bookingDetailRepository.save(bookingDetail) : null;
    }

    @Override
    @Transactional
    public void deleteBooking(long id) {
        bookingDetailRepository.deleteById(id);
    }

    @Override
    @Transactional
    public BookingDetail updateBooking(long id, BookingDetail bookingDetail) {
        return bookingDetailRepository.findById(id).map(
                bd -> {
                    bd.setBooking(bookingDetail.getBooking());
                    bd.setCourtSlots(bookingDetail.getCourtSlots());
                    bd.setPlayingDate(bookingDetail.getPlayingDate());
                    bd.setPrice(bookingDetail.getPrice());
                    bd.setStatus((bookingDetail.isStatus()));
                    return bookingDetailRepository.save(bd);
                }
        ).orElse(null);
    }

    @Override
    public BookingDetail getBooking(long id) {
        return bookingDetailRepository.findById(id).orElse(null);
    }

    @Override
    public List<BookingDetail> getAllBookingDetail() {
        return bookingDetailRepository.findAll();
    }
}
