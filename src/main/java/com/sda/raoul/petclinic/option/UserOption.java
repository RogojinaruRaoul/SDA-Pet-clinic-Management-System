package com.sda.raoul.petclinic.option;

import java.util.Arrays;
import java.util.Optional;

public enum UserOption {
    ADD_NEW_VET("Add new Veterinarian", 1),
    SHOW_ALL("Displays all options", 2),
    DELETE_BY_ID("Deletes veterinarian by id", 3),
    UPDATE("Updates a veterinarian", 4),
    ADD_NEW_PET("Add a new pet", 5),
    VIEW_ALL_VACCINATED_PETS("View all vaccinated pets", 6),
    VIEW_ALL_PETS_FOR_CLIENT_ID("View pet for client id", 7),
    SHOW_ALL_PETS("Displays all pets", 8),
    DELETE_PET_BY_ID("Deletes a pet by id", 9),
    UPDATE_PET_BY_ID("Updates a pet by id", 10),
    ADD_CONSULT("Adds a new consult.",11),
    EXIT("Exit", 999),
    UNKNOWN("Unknown option, try again", 1000);


    public final String prettyName;
    private final int optionNumber;

    UserOption(String prettyName, int optionNumber) {
        this.prettyName = prettyName;
        this.optionNumber = optionNumber;
    }

    public String getPrettyName() {
        return prettyName;
    }

    public int getOptionNumber() {
        return optionNumber;
    }

    public static void printAllOptions() {
        System.out.println("----------------------------------");
        Arrays.stream(UserOption.values())
                .filter(userOption -> !userOption.equals(UserOption.UNKNOWN))
                .forEach(option -> System.out.println(option.prettyName + " -> " + option.getOptionNumber()));
    }

    public static Optional<UserOption> findBy(int optionNumber) {
        return Arrays.stream(UserOption.values())
                .filter(userOption -> userOption.getOptionNumber() == optionNumber)
                .findAny();
    }
}
