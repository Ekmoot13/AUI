package com.example.demo.function;


import com.example.demo.BoatType;
import com.example.demo.dto.GetBoatTypesResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class BoatTypesToResponseFunction implements Function<List<BoatType>, GetBoatTypesResponse> {

    @Override
    public GetBoatTypesResponse apply(List<BoatType> entities) {
        return GetBoatTypesResponse.builder().build().builder()
                .boatTypes(entities.stream()
                        .map(boatType -> GetBoatTypesResponse.BoatType.builder()
                                .id(boatType.getId())
                                .name(boatType.getName())
                                .build())
                        .toList())
                .build();
    }

}
