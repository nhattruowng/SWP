package com.example.booking88be.iservice;

import com.example.booking88be.entity.Promotion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPromotion {

    /**
     * @param promotion
     * @return
     */
    Promotion addPromotion(Promotion promotion);

    /**
     * @param id
     * @param promotion
     * @return
     */
    Promotion updatePromotion(long id, Promotion promotion);

    /**
     * @param id
     * @return
     */
    void deletePromotion(long id);

    /**
     * @return
     */
    List<Promotion> getAllPromotion();

    /**
     * @param id
     * @return
     */
    Promotion getPromotionById(long id);
}
