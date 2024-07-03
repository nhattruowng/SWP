package com.example.booking88be.repository;

import com.example.booking88be.entity.Payment;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaymetRepository extends JpaRepository<Payment,Long> {
}
