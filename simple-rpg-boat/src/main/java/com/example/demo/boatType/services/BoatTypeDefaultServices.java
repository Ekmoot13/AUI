package com.example.demo.boatType.services;

import com.example.demo.boatType.BoatType;
import com.example.demo.boatType.repository.BoatTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class BoatTypeDefaultServices implements BoatTypeService {

    private final BoatTypeRepository repository;

    @Autowired
    public BoatTypeDefaultServices(BoatTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<BoatType> find(UUID id) {
        return repository.findById(id);
    }

    @Override
    public void create(BoatType profession) {
        repository.save(profession);
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
    }
}
