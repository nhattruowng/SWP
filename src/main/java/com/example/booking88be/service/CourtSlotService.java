package com.example.booking88be.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.example.booking88be.entity.*;
import com.example.booking88be.iservice.*;
import com.example.booking88be.repository.*;

import java.util.List;
import java.util.Optional;

@Component
public class CourtSlotService implements ICourtSlot {

    @Autowired
    private ICourtSlotRepository iCourtSlotRepository;


    @Override
    public CourtSlot addCourtSlot(CourtSlot courtSlot) {
        return courtSlot != null ? iCourtSlotRepository.save(courtSlot) : null;
    }

    @Override
    public CourtSlot getCourtSlotById(long id) {
        return iCourtSlotRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void deleteCourtSlot(long id) {
            iCourtSlotRepository.deleteById(id);

    }

    @Override
    @Transactional
    public CourtSlot updateCourtSlot(long id, CourtSlot courtSlot) {
        return iCourtSlotRepository.findById(id).map(
                cs -> {
                    cs.setBookingDetail(courtSlot.getBookingDetail());
                    cs.setCourt(courtSlot.getCourt());
                    cs.setSlot(courtSlot.getSlot());
                    return iCourtSlotRepository.save(cs);
                }
        ).orElse(null);
    }

    @Override
    public List<CourtSlot> getAllCourtSlot() {
        return iCourtSlotRepository.findAll();
    }
}
