package com.example.demo.controller;

import com.example.demo.services.BoatTypeService;
import com.example.demo.dto.GetBoatTypeResponse;
import com.example.demo.dto.GetBoatTypesResponse;
import com.example.demo.function.BoatTypeToResponseFunction;
import com.example.demo.function.BoatTypesToResponseFunction;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

/**
 * Controller for profession resource. It does not return or receive entity objects but dto objects which present only
 * those fields which are used in communication with client.
 */
@RestController
@Log
public class BoatTypeDefaultController implements BoatTypeController {

    private final BoatTypeService service;
    private final BoatTypeToResponseFunction boatTypeToResponse;
    private final BoatTypesToResponseFunction boatTypesToResponse;

    @Autowired
    public BoatTypeDefaultController(
            BoatTypeService service,
            BoatTypeToResponseFunction boatTypeToResponse,
            BoatTypesToResponseFunction boatTypesToResponse
    ) {
        this.service = service;
        this.boatTypeToResponse = boatTypeToResponse;
        this.boatTypesToResponse = boatTypesToResponse;
    }

    @Override
    public GetBoatTypesResponse getBoatTypes() {
        return boatTypesToResponse.apply(service.findAll());
    }

    @Override
    public GetBoatTypeResponse getBoatType(UUID id) {
        return service.find(id)
                .map(boatTypeToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void deleteBoatType(UUID id) {
        service.find(id)
                .ifPresentOrElse(
                        boatType -> service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }

}
