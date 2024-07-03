package com.example.booking88be.repository;

import com.example.booking88be.entity.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISlotRepository extends JpaRepository<Slot,Long> {
}
