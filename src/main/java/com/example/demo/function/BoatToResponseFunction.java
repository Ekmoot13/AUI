package com.example.demo.function;

import com.example.demo.Boat;
import com.example.demo.dto.GetBoatResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class BoatToResponseFunction implements Function<Boat, GetBoatResponse> {

    @Override
    public GetBoatResponse apply(Boat entity) {
        return GetBoatResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .sailArea(entity.getSailArea())
                .boatType(GetBoatResponse.BoatType.builder()
                        .id(entity.getBoatType().getId())
                        .name(entity.getBoatType().getName())
                        .build())
                .build();
    }

}
