package com.sda.raoul.petclinic;

import com.sda.raoul.petclinic.utils.SessionManager;

public class Main {
    public static void main(String[] args) {
        // temporary change until we have the repository implementation
        SessionManager.getSessionFactory().openSession();

    }
}
