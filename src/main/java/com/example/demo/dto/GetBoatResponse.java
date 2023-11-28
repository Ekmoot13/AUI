package com.example.demo.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

/**
 * GET character response. It contains all field that can be presented (but not necessarily changed) to the used. How
 * character is described is defined in {@link GetCharactersResponse.Character}
 * and {@link pl.edu.pg.eti.kask.rpg.creature.entity.Creature} classes.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetBoatResponse {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class BoatType {
        private UUID id;
        private String name;
    }

    private UUID id;
    String name;
    int sailArea;
    private BoatType boatType;
}
