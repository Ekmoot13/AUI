package com.example.demo.boatType.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

public interface BoatTypeController {

    @DeleteMapping("/api/boatTypes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteBoatType(
            @PathVariable("id")
            UUID id
    );
}
