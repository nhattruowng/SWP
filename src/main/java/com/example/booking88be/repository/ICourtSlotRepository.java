package com.example.booking88be.repository;

import com.example.booking88be.entity.CourtSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourtSlotRepository extends JpaRepository<CourtSlot, Long> {
}
