package com.example.booking88be.iservice;

import com.example.booking88be.entity.LocationStaff;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ILocationStaff {

    /**
     * @param locationStaff
     * @return
     */
    LocationStaff addLocationStaff(LocationStaff locationStaff);

    /**
     * @param id
     * @param locationStaff
     * @return
     */
    LocationStaff updateLocationStaff(long id, LocationStaff locationStaff);

    /**
     * @return
     */
    List<LocationStaff> getAllLocationStaff();

    /**
     * @param id
     * @return
     */
    LocationStaff getLocationStaffById(Long id);

    /**
     * @param id
     */
    void deleteLocationStaff(Long id);
}
