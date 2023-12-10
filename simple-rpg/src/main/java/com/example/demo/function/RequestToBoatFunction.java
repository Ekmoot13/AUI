package com.example.demo.function;

import com.example.demo.Boat;
import com.example.demo.BoatType;
import com.example.demo.dto.PutBoatRequest;
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
