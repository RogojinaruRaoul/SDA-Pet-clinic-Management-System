package com.sda.raoul.petclinic;

import com.sda.raoul.petclinic.controller.ClientController;
import com.sda.raoul.petclinic.controller.ConsultController;
import com.sda.raoul.petclinic.controller.PetController;
import com.sda.raoul.petclinic.controller.VeterinarianController;
import com.sda.raoul.petclinic.option.UserOption;
import com.sda.raoul.petclinic.utils.SessionManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SessionManager.getSessionFactory();
        VeterinarianController veterinarianController = new VeterinarianController();
        PetController petController = new PetController();
        ClientController clientController = new ClientController();
        ConsultController consultController = new ConsultController();
        Scanner scanner = new Scanner(System.in);

        UserOption option = UserOption.UNKNOWN;
        do {
            UserOption.printAllOptions();
            System.out.println("Choose an option.");
            String inputOption = scanner.nextLine();
            try {
                int userOption = Integer.parseInt(inputOption);
                option = UserOption.findBy(userOption).orElse(UserOption.UNKNOWN);
            } catch (NumberFormatException e) {
                option = UserOption.UNKNOWN;
            }
            System.out.println(option.getPrettyName());

            switch (option) {
                case ADD_NEW_VET:
                    veterinarianController.create();
                    break;
                case SHOW_ALL:
                    veterinarianController.showAllVeterinarians();
                    break;
                case DELETE_BY_ID:
                    veterinarianController.deleteById();
                    break;
                case UPDATE:
                    veterinarianController.update();
                    break;
                case ADD_NEW_PET:
                    petController.addPet();
                    break;
                case VIEW_ALL_VACCINATED_PETS:
                    petController.showAllVaccinated();
                    break;
                case VIEW_ALL_PETS_FOR_CLIENT_ID:
                    clientController.viewAllPetsForClient();
                    break;
                case SHOW_ALL_PETS:
                    petController.showAllPets();
                    break;
                case DELETE_PET_BY_ID:
                    petController.deleteById();
                    break;
                case UPDATE_PET_BY_ID:
                    petController.updateById();
                    break;
                case ADD_CONSULT:
                    consultController.addConsult();
                    break;
                case VIEW_ALL_CONSULTS_WITH_UNVACCINATED_PETS:
                    consultController.viewAllWithUnvaccinatedPets();
                    break;
                case VIEW_CONSULT_BY_VET_ID_AND_DATE_INTERVAL:
                    consultController.viewAllByVetIdAndDateBetween();
                    break;
                case VIEW_VET_WITH_MULTIPLE_PARAMETERS:
                    veterinarianController.viewByMultipleParameters();
                    break;
                case UNKNOWN:
                    break;
                case EXIT:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("This option is not implemented.");
                    break;
            }
        } while (!option.equals(UserOption.EXIT));

        SessionManager.shutDown();

    }
}
