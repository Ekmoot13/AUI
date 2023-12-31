package com.example.demo.boatType.controller;

import com.example.demo.boatType.dto.GetBoatTypeResponse;
import com.example.demo.boatType.dto.PutBoatTypeRequest;
import com.example.demo.boatType.function.RequestToBoatTypeFunction;
import com.example.demo.boatType.services.BoatTypeService;
import com.example.demo.boatType.dto.GetBoatTypesResponse;
import com.example.demo.boatType.function.BoatTypeToResponseFunction;
import com.example.demo.boatType.function.BoatTypesToResponseFunction;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@Log
public class BoatTypeDefaultController2 implements BoatTypeController {

    private final BoatTypeService service;
    private final BoatTypeToResponseFunction boatTypeToResponse;
    private final BoatTypesToResponseFunction boatTypesToResponse;
    private final RequestToBoatTypeFunction requestToBoatType;

    @Autowired
    public BoatTypeDefaultController2(
            BoatTypeService service,
            BoatTypeToResponseFunction boatTypeToResponse,
            BoatTypesToResponseFunction boatTypesToResponse, RequestToBoatTypeFunction requestToBoatType
    ) {
        this.service = service;
        this.boatTypeToResponse = boatTypeToResponse;
        this.boatTypesToResponse = boatTypesToResponse;
        this.requestToBoatType = requestToBoatType;
    }

    @Override
    public GetBoatTypesResponse getBoatTypes() {
        return boatTypesToResponse.apply(service.findAll());
    }

    @Override
    public void putBoatType(UUID id, PutBoatTypeRequest request) {
        service.create(requestToBoatType.apply(id, request));
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
