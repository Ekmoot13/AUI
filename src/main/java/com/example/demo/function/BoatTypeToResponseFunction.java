package com.example.demo.function;


import com.example.demo.BoatType;
import com.example.demo.dto.GetBoatTypeResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class BoatTypeToResponseFunction implements Function<BoatType, GetBoatTypeResponse> {

    @Override
    public GetBoatTypeResponse apply(BoatType entity) {
        return GetBoatTypeResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

}
