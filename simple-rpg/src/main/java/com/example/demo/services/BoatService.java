package com.example.demo.services;

import com.example.demo.Boat;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface BoatService {
    Optional<Boat> find(UUID id);
    List<Boat> findAll();
    void create(Boat boat);
    void update(Boat boat);
    void delete(UUID id);
    Optional<List<Boat>> findAllByBoatType(UUID boatTypeId);

}
