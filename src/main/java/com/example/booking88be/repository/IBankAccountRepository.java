package com.example.booking88be.repository;

import com.example.booking88be.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBankAccountRepository extends JpaRepository<BankAccount,Long> {
}
