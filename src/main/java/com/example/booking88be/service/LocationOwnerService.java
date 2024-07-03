package com.example.booking88be.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.example.booking88be.entity.*;
import com.example.booking88be.iservice.*;
import com.example.booking88be.repository.*;

import java.util.List;
import java.util.Optional;

@Component
public class LocationOwnerService implements ILocationOwner {


    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ILocationOwnerRepository iLocationOwnerRepository;

    @Override
    public LocationOwner addLocationOwner(Customer owner) {
        LocationOwner locationOwner = iLocationOwnerRepository.getLocationOwnerByEmail(owner.getEmail());
        if(locationOwner!=null){
            locationOwner.setPassword("");
            return locationOwner;
        }
        else {
            locationOwner = new LocationOwner();
            locationOwner.setEmail(owner.getEmail());
            locationOwner.setName(owner.getName());
            locationOwner.setPassword(passwordEncoder.encode(owner.getPassword()));
            locationOwner.setPhone(owner.getPhone());
            //locationOwner.setRole(Role.OWNER.getAuthority().);
            return iLocationOwnerRepository.save(locationOwner);
        }
    }

    @Override
    public LocationOwner getLocationOwnerById(Long id) {
        return iLocationOwnerRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public LocationOwner updateLocationOwner(Long id, LocationOwner owner) {
        if(owner != null){
            Optional<LocationOwner> temp = iLocationOwnerRepository.findById(id);
            if(temp.isPresent()){
                LocationOwner locationOwner = temp.get();
                locationOwner.setEmail(owner.getEmail());
                locationOwner.setName(owner.getName());
                locationOwner.setPassword(passwordEncoder.encode(owner.getPassword()));
                locationOwner.setPhone(owner.getPhone());
                return iLocationOwnerRepository.save(locationOwner);
            }
        }
        return null;
    }

    @Override
    @Transactional
    public void deleteLocationOwner(Long id) {
            iLocationOwnerRepository.deleteById(id);

    }

    @Override
    public List<LocationOwner> getAllLocationOwner() {
        return iLocationOwnerRepository.findAll();
    }
}
