package com.example.booking88be.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.example.booking88be.entity.*;
import com.example.booking88be.iservice.*;
import com.example.booking88be.repository.*;

import java.util.List;

@Component
public class PromotionService implements IPromotion {

    @Autowired
    private IPromotionRepository iPromotionRepository;


    @Override
    public Promotion addPromotion(Promotion promotion) {
        return promotion != null ? iPromotionRepository.save(promotion) : null;
    }

    @Override
    @Transactional
    public Promotion updatePromotion(long id, Promotion promotion) {
        return iPromotionRepository.findById(id).map(
                p -> {
                    p.setBookings(promotion.getBookings());
                    p.setDiscount(promotion.getDiscount());
                    p.setEndDate(promotion.getEndDate());
                    p.setLocation(promotion.getLocation());
                    p.setStartDate(promotion.getStartDate());
                    return iPromotionRepository.save(p);
                }
        ).orElse(null);
    }

    @Override
    @Transactional
    public void deletePromotion(long id) {
        iPromotionRepository.deleteById(id);
    }

    @Override
    public List<Promotion> getAllPromotion() {
        return iPromotionRepository.findAll();
    }

    @Override
    public Promotion getPromotionById(long id) {
        return iPromotionRepository.findById(id).orElse(null);
    }
}
