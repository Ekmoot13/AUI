package com.example.demo.boatType.event.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Repository
public class BoatTypeEventRestRepository implements BoatTypeEventRepository {
    private final RestTemplate restTemplate;

    @Autowired
    public BoatTypeEventRestRepository(RestTemplate template) {
        this.restTemplate = template;
    }

    @Override
    public void delete(UUID id) {
        restTemplate.delete("/api/boatType/{id}", id);
    }

    @Override
    public  void create(UUID id) {
        restTemplate.put("/api/boatType/{id}",null, id);
    }

}
