package com.example.booking88be.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.example.booking88be.entity.*;
import com.example.booking88be.iservice.*;
import com.example.booking88be.repository.*;

import java.util.List;

@Component
public class SlotService implements ISlot {
    @Autowired
    private ISlotRepository iSlotRepository;


    @Override
    public Slot addSlot(Slot slot) {
        return slot != null ? iSlotRepository.save(slot) : null;
    }

    @Override
    public List<Slot> getAllSlot() {
        return iSlotRepository.findAll();
    }

    @Override
    public Slot getSlotById(long id) {
        return iSlotRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Slot updateSlot(long id, Slot slot) {
        return iSlotRepository.findById(id).map(
                s -> {
                    s.setCourtSlots(slot.getCourtSlots());
                    s.setTime(slot.getTime());
                    return iSlotRepository.save(s);
                }
        ).orElse(null);
    }

    @Override
    public void deleteSlot(long id) {
        iSlotRepository.deleteById(id);
    }
}
