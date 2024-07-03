package com.example.booking88be.repository;

import com.example.booking88be.entity.Court;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ICourtRepository extends JpaRepository<Court,Long> {
}
