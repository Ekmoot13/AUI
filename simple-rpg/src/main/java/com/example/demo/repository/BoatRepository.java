package com.example.demo.repository;

import com.example.demo.Boat;
import com.example.demo.BoatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BoatRepository extends JpaRepository<Boat, UUID> {

    List<Boat> findAllByBoatType(BoatType boatType);
}

