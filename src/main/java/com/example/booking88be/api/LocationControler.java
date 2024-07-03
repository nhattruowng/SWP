package com.example.booking88be.api;


import com.example.booking88be.entity.Location;
import com.example.booking88be.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locat")
@ComponentScan(basePackages = {"com.example.booking88be.service",
        "com.example.booking88be.repository",
        "com.example.booking88be.api"})
public class LocationControler {

    private LocationService locationService;


    @Autowired
    public LocationControler(LocationService locationService){
        this.locationService = locationService;
    }


    // create
    @PostMapping("/createLocation")
    public ResponseEntity<?> createLocation(@RequestBody Location location) {
        return ResponseEntity.ok(locationService.addLocation(location));
    }

    // getAll
    @GetMapping("/getLocation")
    public List<Location> getLocation(){
        return locationService.getAllLocation();
    }
    // get id
    @GetMapping("/getLocatID/{id}")
    public Location getLocation(@PathVariable("id") long id){
        return locationService.getLocationById(id);
    }

    // get name
    @GetMapping("/getLocatName/{name}")
    public List<Location> getLocation(@PathVariable("name") String name){
        return locationService.getLocationByName(name);
    }



    // update
    // delete
    // Search
    // updates
    // update status
}