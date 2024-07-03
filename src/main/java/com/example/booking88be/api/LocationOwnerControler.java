package com.example.booking88be.api;


import com.example.booking88be.entity.Customer;
import com.example.booking88be.entity.LocationOwner;
import com.example.booking88be.service.LocationOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owner")
@ComponentScan(basePackages = {"com.example.booking88be.service",
        "com.example.booking88be.repository",
        "com.example.booking88be.api"})
public class LocationOwnerControler {
    private LocationOwnerService locationOwnerService;

    @Autowired
    public LocationOwnerControler(LocationOwnerService locationOwnerService) {
        this.locationOwnerService = locationOwnerService;
    }


    @GetMapping("/getAllLocat")
    public List<LocationOwner> getAllLocat(){return locationOwnerService.getAllLocationOwner();}

    @GetMapping("/getOwner/{id}")
    public LocationOwner getOwner(@PathVariable("id") Long id){
        return locationOwnerService.getLocationOwnerById(id);
    }

    @PostMapping("/create-owner")
    public LocationOwner createOwner(@RequestBody Customer customer){

        return locationOwnerService.addLocationOwner(customer);
    }

    @DeleteMapping("/delete-owner/{id}")
    public void deleteOwner(@PathVariable("id") Long id){
        locationOwnerService.deleteLocationOwner(id);
    }

    @PutMapping("/updateOwner/{id}")
    public LocationOwner updateOwner(@PathVariable("id") Long id,
                                     @RequestBody LocationOwner locationOwner){
        return locationOwnerService.updateLocationOwner(id, locationOwner);
    }
}
