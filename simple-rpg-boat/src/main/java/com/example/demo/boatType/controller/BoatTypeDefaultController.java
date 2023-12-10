package com.example.demo.boatType.controller;

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

    @Autowired
    public BoatTypeDefaultController(
            BoatTypeService service
    ) {
        this.service = service;
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
