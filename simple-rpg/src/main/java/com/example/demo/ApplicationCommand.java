package com.example.demo;

import com.example.demo.services.BoatService;
import com.example.demo.services.BoatTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

@Component
public class ApplicationCommand implements CommandLineRunner {

    private final BoatService boatService;
    private final BoatTypeService boatTypeService;

    @Autowired
    public ApplicationCommand(
            BoatService boatService,
            BoatTypeService boatTypeService
    ) {
        this.boatService = boatService;
        this.boatTypeService = boatTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String command;
        main_loop:
        while (true) {
            System.out.println("1. get_boats");
            System.out.println("2. get_types");
            System.out.println("3. delete_boat");
            System.out.println("4. put_boat");
            System.out.println("5. quit");
            command = scanner.next();
            switch (command) {
                case "help" -> {
                    System.out.println("1. get_boats");
                    System.out.println("2. get_types");
                    System.out.println("3. delete_boat");
                    System.out.println("4. put_boat");
                    System.out.println("5. quit");
                }
                case "1" -> {
                    System.out.println(boatService.findAll());
                }
                case "2" -> {
                    System.out.println(boatTypeService.findAll());
                }
                case "3" -> {
                    try {
                        UUID uuid = UUID.fromString(scanner.next());
                        boatService.delete(uuid);
                        System.out.println("Deleted");
                    } catch (NoSuchElementException ex) {
                        System.out.println("Not Found");
                    }
                }
                case "4" -> {
                    System.out.println("ID");
                    UUID uuid = UUID.fromString(scanner.next());
                    System.out.println("Boat Type ID");
                    UUID uuidBT = UUID.fromString(scanner.next());
                    Optional<BoatType> boatType= boatTypeService.find(uuidBT);
                    if (boatType.isPresent()) {
                        System.out.println("name and sail area");
                        Boat request = Boat.builder()
                                .id(uuid)
                                .name(scanner.next())
                                .sailArea(Integer.parseInt(scanner.next()))
                                .boatType(boatType.get())
                                .build();
                        try {
                            boatService.create(request);
                            System.out.println("Put");
                        } catch (IllegalArgumentException ex) {
                            System.out.println("Bad Request");
                        }
                    }
                    else{
                        System.out.println("Bad Request");
                    }
                }
                case "5" -> {
                    break main_loop;
                }
            }
        }
    }


}
