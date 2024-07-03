package com.example.booking88be.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transactionid")
    private long TransactionId;

    @Column(name = "description")
    private long description;

    @Column(name = "amount")
    private float amount;

    //many to one payment
    // many to one Wallet

    @ManyToOne
    @JoinColumn(name = "WalletId")
    private Wallet wallet;

    @ManyToOne
    @JoinColumn(name = "PaymentId")
    private Payment payment;
}

