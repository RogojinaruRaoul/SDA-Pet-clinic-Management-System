package com.sda.raoul.petclinic.controller;

import com.sda.raoul.petclinic.service.PetService;
import com.sda.raoul.petclinic.service.PetServiceImpl;
import com.sda.raoul.petclinic.service.dto.PetDTO;
import com.sda.raoul.petclinic.service.exception.InvalidParameterException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PetController {

    private static final String DATE_FORMAT = "dd-MM-yyyy";
    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat(DATE_FORMAT);
    private final PetService petService;
    private final Scanner scanner;

    public PetController() {
        this.petService = new PetServiceImpl();
        this.scanner = new Scanner(System.in);
    }

    public void addPet() {
//        String race, Date birthDate, boolean isVaccinated, String ownerFirstName, String ownerLastName
        try {

            System.out.println("Please insert race.");
            String raceInput = scanner.nextLine();

            System.out.println("Please insert date of birth.");
            String dateInput = scanner.nextLine();
            Date birthDate = FORMATTER.parse(dateInput);

            System.out.println("Please insert true if the pet is vaccinated or false otherwise.");
            boolean isVacccinatedState = Boolean.parseBoolean(scanner.nextLine());

            System.out.println("Please insert the owner's first name.");
            String firstName = scanner.nextLine();

            System.out.println("Please insert the owner's last name.");
            String lastName = scanner.nextLine();

            petService.create(raceInput, birthDate, isVacccinatedState, firstName, lastName);
        } catch (ParseException e) {
            System.out.println("Please insert a correct date of birth " + DATE_FORMAT + ".");
        } catch (InputMismatchException e) {
            System.out.println("Please insert true or false for the vaccinated status.");
        } catch (InvalidParameterException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Internal server error.");
        }
    }

    public void showAllVaccinated() {
        petService.findAllVaccinated().stream()
                .forEach(pet -> System.out.println
                        (
                                "\nRace is: " + pet.getRace()
                                        + "\nBirth date is: " + FORMATTER.format(pet.getBirthDate())
                                        + "\nIs vaccinated: " + (pet.getVaccinated() ? "YES" : "NO")
                        )
                );
    }

    public void showAllPets() {
        List<PetDTO> pets = petService.findAll();
        if (pets.isEmpty()) {
            System.out.println("There are no pets!");
            return;
        }
        pets.stream().forEach(petDTO ->
                System.out.println("\n ID: "+petDTO.getId()
                +"\n Race: "+petDTO.getRace()
                +"\n Date Of Birt: "+petDTO.getBirthDate()
                +"\n Is vaccinated: "+petDTO.getVaccinated()
                +"\n Owner name: "+petDTO.getOwnerName()));
    }
}
