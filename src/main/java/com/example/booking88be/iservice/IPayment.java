package com.example.booking88be.iservice;

import com.example.booking88be.entity.Payment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPayment {

    /**
     * @param payment
     * @return
     */
    Payment addPayment(Payment payment);

    /**
     * @return
     */
    List<Payment> getAllPayment();

    /**
     * @param id
     * @return
     */
    Payment getPaymentById(long id);

    /**
     * @param id
     * @param payment
     * @return
     */
    Payment updatePayment(long id, Payment payment);

    /**
     * @param id
     */
    void deletePayment(long id);
}
