package com.example.demo.controller;

import com.example.demo.function.BoatToResponseFunction;
import com.example.demo.function.BoatsToResponseFunction;
import com.example.demo.function.RequestToBoatFunction;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import com.example.demo.*;
import com.example.demo.dto.*;
import com.example.demo.controller.BoatController;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;

@RestController
@Log
public class BoatDefaultController implements BoatController {

    private final BoatService service;
    private final BoatToResponseFunction boatToResponse;
    private final BoatsToResponseFunction boatsToResponse;
    private final RequestToBoatFunction requestToBoat;

    @Autowired
    public BoatDefaultController(
            BoatService service,
            BoatToResponseFunction boatToResponse,
            BoatsToResponseFunction boatsToResponse,
            RequestToBoatFunction requestToBoat
    ) {
        this.service = service;
        this.boatToResponse = boatToResponse;
        this.boatsToResponse = boatsToResponse;
        this.requestToBoat = requestToBoat;
    }

    @Override
    public GetBoatsResponse getBoats() {
        return boatsToResponse.apply(service.findAll());
    }

    @Override
    public GetBoatsResponse getBoatTypeBoats(UUID boatTypeId) {
        return service.findAllByBoatType(boatTypeId)
                .map(boatsToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public GetBoatResponse getBoat(UUID id) {
        return service.find(id)
                .map(boatToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void putBoat(UUID id, PutBoatRequest request) {
        service.create(requestToBoat.apply(id, request));
    }

    @Override
    public void deleteBoat(UUID id) {
        service.find(id)
                .ifPresentOrElse(
                        character -> service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }

}
