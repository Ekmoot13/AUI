package com.example.demo.function;

import com.example.demo.Boat;
import com.example.demo.dto.PatchBoatRequest;

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
