package com.example.booking88be.repository;

import com.example.booking88be.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IImageRepository extends JpaRepository<Image,Long> {
}
