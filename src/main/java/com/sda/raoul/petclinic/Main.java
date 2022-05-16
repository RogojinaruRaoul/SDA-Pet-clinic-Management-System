package com.sda.raoul.petclinic;

import com.sda.raoul.petclinic.controller.VeterinarianController;
import com.sda.raoul.petclinic.utils.SessionManager;

public class Main {
    public static void main(String[] args) {
        SessionManager.getSessionFactory();
        VeterinarianController veterinarianController = new VeterinarianController();
        veterinarianController.create();

    }
}
