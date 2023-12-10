package com.example.demo.boatType.services;


import com.example.demo.boatType.BoatType;

import java.util.Optional;
import java.util.UUID;

public interface BoatTypeService {
    Optional<BoatType> find(UUID id);
    void create(BoatType boatType);

    void delete(UUID id);
}


