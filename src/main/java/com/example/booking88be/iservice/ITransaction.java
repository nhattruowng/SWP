package com.example.booking88be.iservice;

import com.example.booking88be.entity.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITransaction {

    /**
     * @param transaction
     * @return
     */
    Transaction addTransaction(Transaction transaction);

    /**
     * @param id
     * @return
     */
    Transaction getTransactionById(Long id);

    /**
     * @return
     */
    List<Transaction> getAllTransaction();

    /**
     * @param id
     */
    void deleteTransactionById(Long id);

    /**
     * @param id
     * @param transaction
     * @return
     */
    Transaction updateTransaction(long id, Transaction transaction);
}
