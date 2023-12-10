package com.example.demo.boatType.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.example.demo.boatType.dto.GetBoatTypeResponse;
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

    @DeleteMapping("/api/boatTypes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteBoatType(
            @PathVariable("id")
            UUID id
    );
}
