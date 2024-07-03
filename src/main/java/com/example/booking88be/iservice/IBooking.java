package com.example.booking88be.iservice;

import com.example.booking88be.entity.Booking;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface IBooking {

    /**
     * them 1 Booking add vao database entity
     * @param booking
     * @return Booking
     */
    Booking addBooking(Booking booking);

    /**
     * them 2 Booking add vao database entity
     * xoa Booking ra khoi database entity
     * @param id
     */
    void deleteBooking(long id);

    /**
     * update booking entity
     * @param id      tim dia chi cua booking entity
     * @param booking
     * @return Booking update
     */
    Booking updateBooking(long id, Booking booking);

    /**
     * tim 1 booking voi dia chi la 1 id la doi so
     * @param id long
     * @return Booking
     */
    Booking findBookingById(Long id);

    /**
     * lay toan bo booking
     * @return List<Booking>
     */
    List<Booking> getAllBookings();

}
