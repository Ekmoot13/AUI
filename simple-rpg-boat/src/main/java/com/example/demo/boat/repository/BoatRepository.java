package com.example.demo.boat.repository;

import com.example.demo.boat.Boat;
import com.example.demo.boatType.BoatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BoatRepository extends JpaRepository<Boat, UUID> {

    List<Boat> findAllByBoatType(BoatType boatType);
}

