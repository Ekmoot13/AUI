package com.example.demo.boatType.event.repository;


import java.util.UUID;

public interface BoatTypeEventRepository {

    void delete(UUID id);

    void create(UUID id);

}
