package com.example.demo.boatType;

import com.example.demo.boat.Boat;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@Entity
@Table(name = "boatType")
public class BoatType implements Serializable {

    @Id
    private UUID id;

    private String name;

    private int numerOfSailors;

    @OneToMany(mappedBy = "boatType", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    private List<Boat> boats;

    @Override
    public String toString() {
        return "BoatType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numerOfSailors=" + numerOfSailors +
                '}'+'\n';
    }
}
