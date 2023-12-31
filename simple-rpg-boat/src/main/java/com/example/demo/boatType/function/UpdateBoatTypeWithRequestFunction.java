package com.example.demo.boatType.function;

import com.example.demo.boat.Boat;
import com.example.demo.boat.dto.PatchBoatRequest;
import com.example.demo.boatType.BoatType;
import com.example.demo.boatType.dto.PatchBoatTypeRequest;

import java.util.function.BiFunction;

public class UpdateBoatTypeWithRequestFunction implements BiFunction<BoatType, PatchBoatTypeRequest, BoatType> {


    @Override
    public BoatType apply(BoatType entity, PatchBoatTypeRequest request) {
        return BoatType.builder()
                .id(entity.getId())
                .name(request.getName())
                .build();
    }
}