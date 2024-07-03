package com.example.booking88be.iservice;

import com.example.booking88be.entity.Customer;
import com.example.booking88be.entity.LocationOwner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ILocationOwner {

    /**
     * add a new location0wner
     *
     * @param owner
     * @return LocationOwner
     */
    LocationOwner addLocationOwner(Customer owner);

    /**
     * get location owner by id
     *
     * @param id long
     * @return LocationOwner
     */
    LocationOwner getLocationOwnerById(Long id);

    /**
     * update location owner
     *
     * @param id    long
     * @param owner LocationOwner
     * @return LocationOwner updated
     */
    LocationOwner updateLocationOwner(Long id, LocationOwner owner);

    /**
     * delete location owner
     *
     * @param id long
     */
    void deleteLocationOwner(Long id);

    /**
     * get location owner all locations
     *
     * @return List<LocationOwner>
     */
    List<LocationOwner> getAllLocationOwner();

}
