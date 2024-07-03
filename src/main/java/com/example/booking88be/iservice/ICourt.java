package com.example.booking88be.iservice;

import com.example.booking88be.entity.Court;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICourt {
    /**
     * add court
     *
     * @param court
     * @return Court
     */
    Court addCourt(Court court);

    /**
     * get court with id
     *
     * @param id
     * @return Court
     */
    Court getCourtById(long id);

    /**
     * get All court
     *
     * @return List<Court>
     */
    List<Court> getAllCourt();

    /**
     * update court
     *
     * @param id
     * @param court
     * @return Court update
     */
    Court updateCourt(long id, Court court);

    /**
     * delete court
     *
     * @param id
     */
    void deleteCourt(long id);
}
