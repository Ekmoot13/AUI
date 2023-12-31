package com.example.demo.boatType.controller;

import com.example.demo.boatType.dto.PutBoatTypeRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface BoatTypeController {

    @PutMapping("/api/boatTypes/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putBoatType(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PutBoatTypeRequest request
    );

    @DeleteMapping("/api/boatTypes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteBoatType(
            @PathVariable("id")
            UUID id
    );
}
