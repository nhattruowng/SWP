package com.example.booking88be.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.example.booking88be.entity.*;
import com.example.booking88be.iservice.*;
import com.example.booking88be.repository.*;
import java.util.List;

@Component
public class WalletService implements IWallet {

    @Autowired
    private IWalletRepository mWalletRepository;


    @Override
    public Wallet getWallet(long id) {
        return id >= 1 ? mWalletRepository.findById(id).orElse(null) : null;
    }

    @Override
    public List<Wallet> getWalletByUserId(long userId) {
        return List.of();
    }


    @Override
    public Wallet createWallet(Wallet wallet) {
        return wallet != null ? mWalletRepository.save(wallet) : null;
    }

    @Override
    @Transactional
    public Wallet updateWallet(long id, Wallet wallet) {
        return mWalletRepository.findById(id).map(
                w -> {
                    w.setAccountBalance(wallet.getAccountBalance());
                    w.setCustomer(wallet.getCustomer());
                    w.setTransactions(wallet.getTransactions());
                    return mWalletRepository.save(wallet);
                }
        ).orElse(null);
    }

    @Override
    @Transactional
    public void deleteWallet(long id) {
        mWalletRepository.deleteById(id);

    }
}
