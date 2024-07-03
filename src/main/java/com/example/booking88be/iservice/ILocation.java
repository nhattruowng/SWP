package com.example.booking88be.iservice;

import com.example.booking88be.entity.Court;
import com.example.booking88be.entity.CourtSlot;
import com.example.booking88be.entity.Location;
import com.example.booking88be.entity.Slot;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ILocation {

    /**
     * add a location
     * @param location Location
     * @return Location
     */
    Location addLocation(Location location);

    /**
     * get all location
     * @return List<Location>
     */
    List<Location> getAllLocation();

    /**
     * update location
     * @param id long
     * @param location Location
     * @return Location
     */
    Location updateLocation(long id,Location location);

    /**
     * delete location
     * @param id long
     */
    void deleteLocation(long id);

    /**
     * get location by id
     * @param id long
     * @return Location
     */
    Location getLocationById(long id);

    /**
     * find location by name
     * @param name {@link String}
     * @return {@link List<Location>}
     */
    List<Location> getLocationByName(String name);

    /**
     * get courts by location id
     * @param id long
     * @return {@link List<Court>}
     */
    List<Court> getCourtsByLocationId(long id);


    /**
     * update {@link Court} by location id and courtID
     * @param id {@link Location id}
     * @param countID{@link Court id}
     * @param court {@link Court court}
     * @return {@link Court}
     */
    Court updateCourtsByLocationId(long id, long countID, Court court);

    /**
     * @param id
     * @return
     */
    List<CourtSlot> getSlotsByCourtinLocationId(long id, long countID);


    /**
     * update {@link CourtSlot} by location id and courtID and slotID
     * @param id {@link Location id}
     * @param countID {@link Court id}
     * @param slotID {@link Slot id}
     * @param courtSlot {@link CourtSlot}
     * @return {@link CourtSlot}
     */

    CourtSlot updateCourtSlot(long id,long countID , long slotID,CourtSlot courtSlot);


}
