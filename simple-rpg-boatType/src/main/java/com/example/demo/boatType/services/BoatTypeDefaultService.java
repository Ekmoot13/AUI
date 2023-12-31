package com.example.demo.boatType.services;

import com.example.demo.boatType.event.repository.BoatTypeEventRepository;
import com.example.demo.boatType.repository.BoatTypeRepository;
import com.example.demo.boatType.BoatType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BoatTypeDefaultService implements BoatTypeService {

    private final BoatTypeRepository repository;
    private final BoatTypeEventRepository eventRepository;




    @Autowired
    public BoatTypeDefaultService(BoatTypeRepository repository, BoatTypeEventRepository eventRepository) {
        this.eventRepository = eventRepository;
        this.repository = repository;
    }

    @Override
    public Optional<BoatType> find(UUID id) {
        return repository.findById(id);
    }

    @Override
    public void create(BoatType boatType) {
        repository.save(boatType);
    }

    @Override
    public List<BoatType> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
        eventRepository.delete(id);

    }

}
