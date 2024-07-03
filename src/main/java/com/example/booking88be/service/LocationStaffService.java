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
public class LocationStaffService implements ILocationStaff {

    @Autowired
    private ILocationStaffRepository iLocationStaffRepository;


    @Override
    public LocationStaff addLocationStaff(LocationStaff locationStaff) {
        return locationStaff!=null ? iLocationStaffRepository.save(locationStaff) : null;
    }

    @Override
    @Transactional
    public LocationStaff updateLocationStaff(long id, LocationStaff locationStaff) {
        return iLocationStaffRepository.findById(id).map(
                ls ->{
                    ls.setEmail(locationStaff.getEmail());
                    ls.setLocationOwner(locationStaff.getLocationOwner());
                    ls.setName(locationStaff.getName());
                    ls.setPassword(locationStaff.getPassword());
                    ls.setPhone(locationStaff.getPhone());
                    return iLocationStaffRepository.save(ls);
                }
        ).orElse(null);
    }

    @Override
    public List<LocationStaff> getAllLocationStaff() {
        return iLocationStaffRepository.findAll();
    }

    @Override
    public LocationStaff getLocationStaffById(Long id) {
        return iLocationStaffRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteLocationStaff(Long id) {

            iLocationStaffRepository.deleteById(id);
    }
}
