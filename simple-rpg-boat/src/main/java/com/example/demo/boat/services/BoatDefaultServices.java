package com.example.demo.boat.services;


import com.example.demo.boat.Boat;
import com.example.demo.boat.repository.BoatRepository;
import com.example.demo.boatType.repository.BoatTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;



@Service
public class BoatDefaultServices implements BoatService {
    private final BoatRepository repository;
    private final BoatTypeRepository boatTypeRepository;

    @Autowired
    public BoatDefaultServices(BoatRepository repository, BoatTypeRepository boatTypeRepository) {
        this.repository = repository;
        this.boatTypeRepository = boatTypeRepository;
    }

    @Override
    public Optional<Boat> find(UUID id) {
        return repository.findById(id);
    }

    @Override
    public List<Boat> findAll() {
        return repository.findAll();
    }

    @Override
    public void create(Boat boat) {
        repository.save(boat);
    }

    @Override
    public void update(Boat boat) {
        repository.save(boat);
    }

    @Override
    public Optional<List<Boat>> findAllByBoatType(UUID boatTypeId) {
        return boatTypeRepository.findById(boatTypeId)
                .map(repository::findAllByBoatType);
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
    }

}
