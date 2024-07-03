package com.example.booking88be.iservice;

import com.example.booking88be.entity.CourtSlot;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface ICourtSlot {


    /**
     * add court slot to court
     *
     * @param courtSlot
     * @return CourtSlot
     */
    CourtSlot addCourtSlot(CourtSlot courtSlot);

    /**
     * get court slot by id
     *
     * @param id long
     * @return CourtSlot
     */
    CourtSlot getCourtSlotById(long id);

    /**
     * delete Court slot by id
     *
     * @param id long
     */
    void deleteCourtSlot(long id);

    /**
     * update court slot by
     *
     * @param courtSlot
     * @param id        long
     * @return courtSlot
     */
    CourtSlot updateCourtSlot(long id, CourtSlot courtSlot);

    /**
     * get all Court slot
     *
     * @return List<CourtSlot>
     */
    List<CourtSlot> getAllCourtSlot();
}
