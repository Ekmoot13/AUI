package com.example.demo.boat.function;

import com.example.demo.boat.Boat;
import com.example.demo.boat.dto.PatchBoatRequest;

import java.util.function.BiFunction;

public class UpdateBoatWithRequestFunction implements BiFunction<Boat, PatchBoatRequest, Boat> {

    @Override
    public Boat apply(Boat entity, PatchBoatRequest request) {
        return Boat.builder()
                .id(entity.getId())
                .name(request.getName())
                .sailArea(request.getSailArea())
                .boatType(entity.getBoatType())
                .build();
    }

}
