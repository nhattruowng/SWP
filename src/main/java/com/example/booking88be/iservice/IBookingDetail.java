package com.example.booking88be.iservice;

import com.example.booking88be.entity.BookingDetail;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBookingDetail {

    /**
     * Add bookingdetail
     *
     * @param bookingDetail
     * @return BookingDetail
     */
    BookingDetail addBooking(BookingDetail bookingDetail);

    /**
     * Remove bookingdetail
     *
     * @param id
     */
    void deleteBooking(long id);

    /**
     * Update bookingdetail
     *
     * @param bookingDetail
     * @return BookingDetail
     */
    BookingDetail updateBooking(long id, BookingDetail bookingDetail);

    /**
     * getBookingDetail
     *
     * @param id
     * @return BookingDetail
     */
    BookingDetail getBooking(long id);

    /**
     * getAllBookingdetails
     *
     * @return List<BookingDetail>
     */
    List<BookingDetail> getAllBookingDetail();
}
