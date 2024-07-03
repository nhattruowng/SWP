package com.example.booking88be.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.example.booking88be.entity.*;
import com.example.booking88be.iservice.*;
import com.example.booking88be.repository.*;

import java.util.List;

@Component
public class LocationService implements ILocation {

    @Autowired
    private ILocationRepository iLocationRepository;


    @Override
    public Location addLocation(Location location) {
        return location != null ? iLocationRepository.save(location) : null;
    }

    @Override
    public List<Location> getAllLocation() {
        return iLocationRepository.findAll();
    }

    @Override
    @Transactional
    public Location updateLocation(long id, Location location) {
        return iLocationRepository.findById(id).map(
                l ->{
                    l.setAddress(location.getAddress());
                    l.setCloseTime(location.getCloseTime());
                    l.setCourts(location.getCourts());
                    l.setDescription(location.getDescription());
                    l.setHotline(location.getHotline());
                    l.setImages(location.getImages());
                    l.setLocationOwner(location.getLocationOwner());
                    l.setName(location.getName());
                    l.setOpenTime(location.getOpenTime());
                    l.setPromotions(location.getPromotions());
                    l.setStatus(location.getStatus());
                    return iLocationRepository.save(l);
                }
        ).orElse(null);
    }

    @Override
    @Transactional
    public void deleteLocation(long id) {

            iLocationRepository.deleteById(id);

    }

    @Override
    public Location getLocationById(long id) {
        return iLocationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Location> getLocationByName(String name) {
        return iLocationRepository.findByName(name);
    }

    @Override
    public List<Court> getCourtsByLocationId(long id) {
        Location location = iLocationRepository.findById(id).orElse(null);
       return location!=null ? location.getCourts() : null;
    }

    @Override
    public Court updateCourtsByLocationId(long id, long countID, Court court) {
        return null;
    }

    @Override
    public List<CourtSlot> getSlotsByCourtinLocationId(long id, long countID) {

        List<Court> courts = getCourtsByLocationId(id);
        for (Court c: courts) {
            if (c.getCountID() == countID) {
                return c.getSlots();
            }
        }
        return null;
    }

    @Override
    public CourtSlot updateCourtSlot(long id, long countID, long slotID, CourtSlot courtSlot) {

        return null;
    }


}
