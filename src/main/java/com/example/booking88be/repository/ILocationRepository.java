package com.example.booking88be.repository;

import com.example.booking88be.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILocationRepository extends JpaRepository<Location, Long> {

    @Query(value = "select u from Location u where u.name = :name")
    List<Location> findByName(@Param("name") String name);

}
