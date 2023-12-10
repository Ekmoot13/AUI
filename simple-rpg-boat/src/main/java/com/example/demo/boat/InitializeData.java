package com.example.demo.boat;

import com.example.demo.boat.services.BoatService;
import com.example.demo.boatType.BoatType;
import com.example.demo.boatType.services.BoatTypeService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {
    private final BoatService boatService;

    private final BoatTypeService boatTypeService;

    @Autowired
    public InitializeData(BoatService boatService, BoatTypeService boatTypeService) {
        this.boatService = boatService;
        this.boatTypeService = boatTypeService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        BoatType dingy = BoatType.builder()
                    .id(UUID.fromString("f5875513-bf7b-4ae1-b8a5-5b70a1b90e76"))
                    .name("Dingy")
                    .build();

        BoatType skiff = BoatType.builder()
                    .id(UUID.fromString("5d1da2ae-6a14-4b6d-8b4f-d117867118d4"))
                    .name("Skiff")
                    .build();

        BoatType surf = BoatType.builder()
                    .id(UUID.fromString("2d9b1e8c-67c5-4188-a911-5f064a63d8cd"))
                    .name("Surf")
                    .build();

        boatTypeService.create(dingy);
        boatTypeService.create(skiff);
        boatTypeService.create(surf);

        Boat character0 = Boat.builder().id(UUID.fromString("525d3e7b-bb1f-4c13-bf17-926d1a12e4c0")).name("europa").sailArea( 10).boatType(dingy).build();
        Boat character1 = Boat.builder().id(UUID.fromString("cc0b0577-bb6f-45b7-81d6-3db88e6ac19f")).name("420").sailArea( 20).boatType(dingy).build();
        Boat character2 = Boat.builder().id(UUID.fromString("f08ef7e3-7f2a-4378-b1fb-2922d730c70d")).name("470").sailArea( 30).boatType(dingy).build();
        Boat character3 = Boat.builder().id(UUID.fromString("ff327e8a-77c0-4f9b-90a2-89e16895d1e1")).name("29er").sailArea( 30).boatType(skiff).build();
        Boat character4 = Boat.builder().id(UUID.fromString("ff327e8a-77c0-4f9b-90a2-89e16845d1e1")).name("49er").sailArea( 50).boatType(skiff).build();
        Boat character5 = Boat.builder().id(UUID.fromString("525d3e7b-341f-4c13-bf17-926d1a12e4c0")).name("openSkiff").sailArea( 10).boatType(skiff).build();
        Boat character6 = Boat.builder().id(UUID.fromString("525d3e7b-bb1f-4c13-bf17-926d1a12e4c1")).name("Windsurffing").sailArea( 15).boatType(surf).build();
        Boat character7 = Boat.builder().id(UUID.fromString("5d1da2ae-6a14-4b6d-8b4f-d117867118d9")).name("Kitesurffing").sailArea( 35).boatType(surf).build();
        Boat character8 = Boat.builder().id(UUID.fromString("5d1da2ae-6a14-4b6d-8b4f-d117867118d3")).name("Wing").sailArea( 5).boatType(surf).build();


        boatService.create(character0);
        boatService.create(character1);
        boatService.create(character2);
        boatService.create(character3);
        boatService.create(character4);
        boatService.create(character5);
        boatService.create(character6);
        boatService.create(character7);
        boatService.create(character8);
    }

    @SneakyThrows
    private byte[] getResourceAsByteArray(String name) {
        try (InputStream is = this.getClass().getResourceAsStream(name)) {
            return is.readAllBytes();
        }
    }

}
