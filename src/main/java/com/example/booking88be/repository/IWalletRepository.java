package com.example.booking88be.repository;

import com.example.booking88be.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IWalletRepository extends JpaRepository<Wallet,Long> {
//    List<Wallet> findByCustomerId(Long customerId);
}
