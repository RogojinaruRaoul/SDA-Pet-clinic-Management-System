package com.sda.raoul.petclinic.controller;

import com.sda.raoul.petclinic.service.ClientService;
import com.sda.raoul.petclinic.service.ClientServiceImpl;

import java.util.Scanner;

public class ClientController {

    private final ClientService clientService;
    private Scanner scanner;

    public ClientController() {
        this.clientService = new ClientServiceImpl();
        this.scanner = new Scanner(System.in);
    }

    public void viewAllPetsForClient() {
        try {
            System.out.println("Please insert a client's id.");
            long clientId = Long.parseLong(scanner.nextLine());
            clientService.findPetsForClientID(clientId).stream()
                    .forEach(pet -> System.out.println(pet));
        } catch (NumberFormatException e) {
            System.out.println("Please insert a valid client id.");
        } catch (Exception e) {
            System.out.println("Internal server error.");
            e.printStackTrace();
        }
    }
}
