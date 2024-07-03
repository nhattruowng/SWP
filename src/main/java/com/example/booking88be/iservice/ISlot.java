package com.example.booking88be.iservice;

import com.example.booking88be.entity.Slot;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISlot {

    /**
     * @param slot
     * @return
     */
    Slot addSlot(Slot slot);

    /**
     * @return
     */
    List<Slot> getAllSlot();

    /**
     * @param id
     * @return
     */
    Slot getSlotById(long id);

    /**
     * @param id
     * @param slot
     * @return
     */
    Slot updateSlot(long id, Slot slot);

    /**
     * @param id
     */
    void deleteSlot(long id);
}
