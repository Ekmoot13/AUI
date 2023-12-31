package com.example.demo.boatType.controller;

import com.example.demo.boatType.dto.GetBoatTypeResponse;
import com.example.demo.boatType.dto.PutBoatTypeRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.demo.boatType.dto.GetBoatTypesResponse;

import java.util.UUID;

public interface BoatTypeController {

    @GetMapping("api/boatTypes")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetBoatTypesResponse getBoatTypes();

    @GetMapping("/api/boatTypes/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetBoatTypeResponse getBoatType(
            @PathVariable("id")
            UUID id
    );

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
