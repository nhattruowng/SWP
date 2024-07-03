package com.example.booking88be.iservice;

import com.example.booking88be.entity.Wallet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IWallet {


    /**
     * get wallet with id
     * @param id long
     * @return wallet
     */
    Wallet getWallet(long id);

    /**
     * get wallet with user id
     * @param userId long
     * @return wallet list
     */
    List<Wallet> getWalletByUserId(long userId);

    /**
     * create wallet
     * @param wallet wallet
     * @return wallet
     */
    Wallet createWallet(Wallet wallet);

    /**
     * update wallet
     * @param wallet wallet
     * @return wallet
     */
    Wallet updateWallet(long id,Wallet wallet);

    /**
     * delete wallet
     * @param id long
     */
    void deleteWallet(long id);

}
