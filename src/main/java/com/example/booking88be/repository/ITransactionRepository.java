package com.example.booking88be.repository;

import com.example.booking88be.entity.Transaction;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

@Registered
public interface ITransactionRepository extends JpaRepository<Transaction,Long> {
}
