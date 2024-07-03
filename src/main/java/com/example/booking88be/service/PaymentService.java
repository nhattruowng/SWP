package com.example.booking88be.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.example.booking88be.entity.*;
import com.example.booking88be.iservice.*;
import com.example.booking88be.repository.*;

import java.util.List;
import java.util.Optional;

@Component
public class PaymentService implements IPayment {
    @Autowired
    private IPaymetRepository iPaymetRepository;


    @Override
    public Payment addPayment(Payment payment) {
        return payment != null ? iPaymetRepository.save(payment) : null;
    }

    @Override
    public List<Payment> getAllPayment() {
        return iPaymetRepository.findAll();
    }

    @Override
    public Payment getPaymentById(long id) {
        return iPaymetRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Payment updatePayment(long id, Payment payment) {
        return iPaymetRepository.findById(id).map(
                p -> {
                    p.setBookings(payment.getBookings());
                    p.setPaymentMethod(payment.getPaymentMethod());
                    p.setPaymentStatus(payment.isPaymentStatus());
                    p.setTransactions(payment.getTransactions());
                    return iPaymetRepository.save(p);
                }
        ).orElse(null);
    }

    @Override
    public void deletePayment(long id) {
            iPaymetRepository.deleteById(id);
    }
}
