package com.sda.raoul.petclinic.service;

import com.sda.raoul.petclinic.model.Consult;
import com.sda.raoul.petclinic.model.Pet;
import com.sda.raoul.petclinic.model.Veterinarian;
import com.sda.raoul.petclinic.repository.*;

import java.util.Date;
import java.util.Optional;

public class ConsultServiceImpl implements ConsultService {
    private final VeterinarianRepository veterinarianRepository;
    private final ConsultRepository consultRepository;
    private final PetRepository petRepository;


    public ConsultServiceImpl() {
        this.veterinarianRepository = new VeterinarianRepositoryImpl();
        this.consultRepository = new ConsultRepositoryImpl();
        this.petRepository = new PetRepositoryImpl();
    }

    @Override
    public void create(Long veterinarianId, Long petId, Date date, String description) {
        if (veterinarianId.equals(null)) {
            System.out.println("The veterinarian's id is null");
        }
        if (petId.equals(null)) {
            System.out.println("The pet's id is null");
        }
        if (date.equals(new Date())) {
            System.out.println("The consult's date is in the future.");
        }
        if (description.equals(null) || description.isBlank()) {
            System.out.println("The description is empty.");
        }

        Optional<Veterinarian> veterinarianResult = veterinarianRepository.findById(veterinarianId);
        if (veterinarianResult.isEmpty()) {
//            Veterinarian veterinarian = new Veterinarian();
//            veterinarianRepository.create(veterinarian);
//            veterinarianResult = Optional.of(veterinarian);
            System.out.println("Please select an existing veterinarian id.");
            return;
        }

        Optional<Pet> petResult = petRepository.findById(petId);
        if (petResult.isEmpty()) {
//            Pet pet = new Pet();
//            petRepository.create(pet);
//            petResult = Optional.of(pet);
            System.out.println("Please select an existing pet id.");
            return;
        }
        Consult consult = new Consult(date, description);
        consult.setDate(date);
        consult.setDescription(description);
        consultRepository.create(consult);

    }
}
