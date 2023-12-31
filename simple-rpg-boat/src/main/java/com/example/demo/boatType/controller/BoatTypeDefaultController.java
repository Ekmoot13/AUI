package com.example.demo.boatType.controller;

import com.example.demo.boat.dto.PutBoatRequest;
import com.example.demo.boatType.dto.PutBoatTypeRequest;
import com.example.demo.boatType.function.RequestToBoatTypeFunction;
import com.example.demo.boatType.services.BoatTypeService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@Log
public class BoatTypeDefaultController implements BoatTypeController {

    private final BoatTypeService service;
    private final RequestToBoatTypeFunction requestToBoatType;

    @Autowired
    public BoatTypeDefaultController(
            BoatTypeService service,
            RequestToBoatTypeFunction requestToBoatType
    ) {
        this.service = service;
        this.requestToBoatType = requestToBoatType;
    }


    @Override
    public void putBoatType(UUID id, PutBoatTypeRequest request) {
        service.create(requestToBoatType.apply(id, request));
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
