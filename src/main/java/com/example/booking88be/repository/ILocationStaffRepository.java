package com.example.booking88be.repository;

import com.example.booking88be.entity.LocationStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILocationStaffRepository extends JpaRepository<LocationStaff, Long> {
}
