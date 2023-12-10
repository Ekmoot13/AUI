package com.example.demo.boat.function;

import com.example.demo.boat.Boat;
import com.example.demo.boat.dto.GetBoatsResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class BoatsToResponseFunction implements Function<List<Boat>, GetBoatsResponse> {

    @Override
    public GetBoatsResponse apply(List<Boat> entities) {
        return GetBoatsResponse.builder()
                .boats(entities.stream()
                        .map(boat -> GetBoatsResponse.Boat.builder()
                                .id(boat.getId())
                                .name(boat.getName())
                                .build())
                        .toList())
                .build();
    }

}
