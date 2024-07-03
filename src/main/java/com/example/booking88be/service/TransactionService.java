package com.example.booking88be.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.example.booking88be.entity.*;
import com.example.booking88be.iservice.*;
import com.example.booking88be.repository.*;

import java.util.List;

@Component
public class TransactionService implements ITransaction {

    @Autowired
    private ITransactionRepository iTransactionRepository;


    @Override
    public Transaction addTransaction(Transaction transaction) {
        return transaction != null ? iTransactionRepository.save(transaction) : null;
    }

    @Override
    public Transaction getTransactionById(Long id) {
        return iTransactionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Transaction> getAllTransaction() {
        return iTransactionRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteTransactionById(Long id) {
        iTransactionRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Transaction updateTransaction(long id, Transaction transaction) {
        return iTransactionRepository.findById(id).map(
                t -> {
                    t.setAmount(transaction.getAmount());
                    t.setDescription(transaction.getDescription());
                    t.setPayment(transaction.getPayment());
                    t.setWallet(transaction.getWallet());
                    return iTransactionRepository.save(t);
                }
        ).orElse(null);
    }
}
