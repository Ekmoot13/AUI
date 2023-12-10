package com.example.demo.boatType.repository;

import com.example.demo.boatType.BoatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BoatTypeRepository extends JpaRepository<BoatType, UUID> {

}

