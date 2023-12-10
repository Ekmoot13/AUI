package com.example.demo.boat.function;

import com.example.demo.boat.Boat;
import com.example.demo.boatType.BoatType;
import com.example.demo.boat.dto.PutBoatRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToBoatFunction implements BiFunction<UUID, PutBoatRequest, Boat> {

    @Override
    public Boat apply(UUID id, PutBoatRequest request) {
        return Boat.builder()
                .id(id)
                .name(request.getName())
                .sailArea(request.getSailArea())
                .boatType(BoatType.builder()
                        .id(request.getBoatType())
                        .build())
                .build();
    }

}
