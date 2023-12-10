package com.example.demo.boatType.function;


import com.example.demo.boatType.BoatType;
import com.example.demo.boatType.dto.PutBoatTypeRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToBoatTypeFunction implements BiFunction<UUID, PutBoatTypeRequest, BoatType> {

    @Override
    public BoatType apply(UUID id, PutBoatTypeRequest request) {
        return BoatType.builder()
                .id(id)
                .name(request.getName())
                .build();
    }

}
