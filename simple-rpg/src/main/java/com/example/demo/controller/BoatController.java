package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.dto.GetBoatResponse;
import com.example.demo.dto.GetBoatsResponse;
import com.example.demo.dto.PutBoatRequest;

import java.util.UUID;

public interface BoatController {

    @GetMapping("api/boats")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetBoatsResponse getBoats();

    @GetMapping("/api/boatTypes/{boatTypeId}/boats")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetBoatsResponse getBoatTypeBoats(
            @PathVariable("boatTypeId")
            UUID professionId
    );

    @GetMapping("/api/boats/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetBoatResponse getBoat(
            @PathVariable("id")
            UUID id
    );

    @PutMapping("/api/boats/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putBoat(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PutBoatRequest request
    );

    @DeleteMapping("/api/boats/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteBoat(
            @PathVariable("id")
            UUID id
    );

}
