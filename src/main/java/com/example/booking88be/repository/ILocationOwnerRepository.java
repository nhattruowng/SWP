package com.example.booking88be.repository;

import com.example.booking88be.entity.LocationOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILocationOwnerRepository extends JpaRepository<LocationOwner, Long> {
    LocationOwner getLocationOwnerByEmail(String email);
}
