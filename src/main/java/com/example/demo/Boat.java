package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity

@Table(name = "boats")

public class Boat implements Serializable {

    @Id
    private UUID id;

    String name;

    int sailArea;

    @ManyToOne
    @JoinColumn(name = "boatType")
    private BoatType boatType;

    @Override
    public String toString() {
        return "Boat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sailArea=" + sailArea +
                ", boatType=" + boatType.getName() +
                '}' + '\n';
    }
}
