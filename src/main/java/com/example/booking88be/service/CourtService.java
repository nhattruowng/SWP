package com.example.booking88be.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.example.booking88be.entity.*;
import com.example.booking88be.iservice.*;
import com.example.booking88be.repository.*;

import java.beans.Transient;
import java.util.List;

@Component
public class CourtService implements ICourt {
    @Autowired
    private ICourtRepository courtRepository;


    @Override
    public Court addCourt(Court court) {
        return court != null ? courtRepository.save(court) : null;
    }

    @Override
    public Court getCourtById(long id) {
        return courtRepository.findById(id).orElse(null);
    }

    @Override
    public List<Court> getAllCourt() {
        return courtRepository.findAll();
    }

    @Override
    @Transactional
    public Court updateCourt(long id, Court court) {
        return courtRepository.findById(id).map(
                c ->{
                    c.setLocation(court.getLocation());
                    c.setName((court.getName()));
                    c.setSlots(court.getSlots());
                    return courtRepository.save(c);
                }
        ).orElse(null);
    }

    @Override
    public void deleteCourt(long id) {
         courtRepository.deleteById(id);
    }
}
