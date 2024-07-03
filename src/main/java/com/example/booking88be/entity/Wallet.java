package com.example.booking88be.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "wallet")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WalletId")
    private long WalletId;
    @Column(name = "AccountBalance")
    private float AccountBalance;

    @OneToOne
    private Customer customer;

    @OneToMany(mappedBy = "wallet",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Transaction> transactions;
}
