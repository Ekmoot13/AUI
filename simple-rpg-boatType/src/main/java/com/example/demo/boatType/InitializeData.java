package com.example.demo.boatType;

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

    private final BoatTypeService boatTypeService;

    @Autowired
    public InitializeData(BoatTypeService boatTypeService) {
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
    }
}
