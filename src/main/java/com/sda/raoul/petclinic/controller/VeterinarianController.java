package com.sda.raoul.petclinic.controller;

import com.sda.raoul.petclinic.service.VeterinarianService;
import com.sda.raoul.petclinic.service.VeterinarianServiceImpl;
import com.sda.raoul.petclinic.service.dto.VeterinarianDTO;
import com.sda.raoul.petclinic.service.exception.InvalidParameterException;

import java.util.List;
import java.util.Scanner;

public class VeterinarianController {

    private final VeterinarianService veterinarianService;
    private Scanner scanner;

    public VeterinarianController() {
        this.veterinarianService = new VeterinarianServiceImpl();
        scanner = new Scanner(System.in);
    }

    public void create() {
        try {
            System.out.println("Please insert first name:");
            String firstName = scanner.nextLine();
            System.out.println("Please insert last name:");
            String lastName = scanner.nextLine();
            System.out.println("Please insert the address:");
            String address = scanner.nextLine();
            System.out.println("Please insert the speciality:");
            String speciality = scanner.nextLine();

            veterinarianService.create(firstName, lastName, address, speciality);
            System.out.println("The veterinarian " + firstName + " was created.");
        } catch (InvalidParameterException e) {
            System.out.println(e.getMessage());
        } catch (Exception ex) {
            System.out.println("The veterinarian was not created, internal server error.");
        }
    }

    public void showAllVeterinarians() {
        List<VeterinarianDTO> vets = veterinarianService.findAll();
        if (vets.isEmpty()) {
            System.out.println("There are no vets!");
            return;
        }
        vets.stream()
                .forEach(veterinarianDTO ->
                        System.out.println(
                                "\n ID: " + veterinarianDTO.getId()
                                        + "\n First Name: " + veterinarianDTO.getFirstName()
                                        + "\n Last Name: " + veterinarianDTO.getLastName()
                                        + "\n Address: " + veterinarianDTO.getAddress()
                                        + "\n Speciality: " + veterinarianDTO.getSpeciality()));
    }


}