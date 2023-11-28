package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BoatTypeDefaultService implements BoatTypeService {

    private final BoatTypeRepository repository;

    @Autowired
    public BoatTypeDefaultService(BoatTypeRepository repository) {
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
    public List<BoatType> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
    }



}
