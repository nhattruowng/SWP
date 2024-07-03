package com.example.booking88be.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "bank_account")
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bank_account_id")
    private long bankAccountId;
    @Column(name = "bank_account_name")
    private String accountNumber;
    @Column(name = "account_holder_name")
    private String accountHolderName;
    @Column(name = "account_name")
    private String bankName;
    @Column(name = "branch_name")
    private String branchName;
    @Column(name = "balance")
    private double balance;
    @Column(name = "created_date")
    private String createdDate;
    @Column(name = "is_active")
    private boolean isActive;
}
