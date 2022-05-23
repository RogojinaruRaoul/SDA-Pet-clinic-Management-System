package com.sda.raoul.petclinic.service;

import com.sda.raoul.petclinic.model.Consult;
import com.sda.raoul.petclinic.model.Pet;
import com.sda.raoul.petclinic.model.Veterinarian;
import com.sda.raoul.petclinic.repository.*;
import com.sda.raoul.petclinic.service.exception.InvalidParameterException;

import java.util.Date;
import java.util.List;
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
    public void create(Long veterinarianId, Long petId, Date date, String description) throws InvalidParameterException {
        if (veterinarianId == null) {
            throw new InvalidParameterException("The veterinarian's id is null");
        }
        if (petId == null) {
            throw new InvalidParameterException("The pet's id is null");
        }
        if (date == null) {
            throw new InvalidParameterException("The date is null");
        }
        if (description == null || description.isBlank()) {
            throw new InvalidParameterException("The description is null or blank");
        }

        Optional<Veterinarian> veterinarianResult = veterinarianRepository.findById(veterinarianId);
        if (veterinarianResult.isEmpty()) {
            throw new InvalidParameterException("Invalid vet id");
        }

        Optional<Pet> petResult = petRepository.findById(petId);
        if (petResult.isEmpty()) {
            throw new InvalidParameterException("Invalid pet id");
        }
        Consult consult = new Consult(date, description);
        consult.setDate(date);
        consult.setDescription(description);

        consult.setVeterinarian(veterinarianResult.get());
        consult.setPet(petResult.get());
        consultRepository.create(consult);
    }

    @Override
    public List<Consult> findAllWithUnvaccinatedPets() {
        return consultRepository.findAllWithUnvaccinatedPets();
    }

    @Override
    public List<Consult> findAllByVetIdAndDateBetween(Long vetID, Date startDate, Date endDate) throws InvalidParameterException {
        if (vetID == null) {
            throw new InvalidParameterException("Invalid vet id.");
        }
        if (startDate == null) {
            throw new InvalidParameterException("Invalid start date.");
        }
        if (endDate == null) {
            throw new InvalidParameterException("Invalid end date.");
        }

        return consultRepository.findAllByVetIdAndDateBetween(vetID, startDate, endDate);
    }
}
