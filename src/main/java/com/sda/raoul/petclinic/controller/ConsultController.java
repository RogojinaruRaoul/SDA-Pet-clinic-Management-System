package com.sda.raoul.petclinic.controller;

import com.sda.raoul.petclinic.service.ConsultService;
import com.sda.raoul.petclinic.service.ConsultServiceImpl;
import com.sda.raoul.petclinic.service.exception.InvalidParameterException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsultController {

    private static final String DATE_FORMAT = "dd-MM-yyyy";
    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat(DATE_FORMAT);
    private final ConsultService consultService;
    private final Scanner scanner;

    public ConsultController() {
        this.consultService = new ConsultServiceImpl();
        this.scanner = new Scanner(System.in);
    }

    public void addConsult() {
//        veterinarian_id, pet_id, date, description.
        try {

            System.out.println("Please insert veterinarian's id.");
            String vetIdInput = scanner.nextLine();
            Long vetId=Long.parseLong(vetIdInput);

            System.out.println("Please insert pets's id.");
            String petIdInput = scanner.nextLine();
            Long petId=Long.parseLong(petIdInput);

            System.out.println("Please insert the consult's date.");
            String dateInput=scanner.nextLine();
            Date birthDate = FORMATTER.parse(dateInput);

            System.out.println("Please insert the consult's description.");
            String descriptionInput = scanner.nextLine();

           consultService.create(vetId,petId,birthDate,descriptionInput);
        } catch (ParseException e) {
            System.out.println("Please insert a correct date " + DATE_FORMAT + ".");
        } catch (Exception e) {
            System.out.println("Internal server error.");
        }
    }
}
