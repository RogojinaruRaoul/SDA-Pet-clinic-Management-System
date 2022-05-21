package com.sda.raoul.petclinic.service;

import com.sda.raoul.petclinic.model.Client;
import com.sda.raoul.petclinic.model.Pet;
import com.sda.raoul.petclinic.repository.ClientRepository;
import com.sda.raoul.petclinic.repository.ClientRepositoryImpl;
import com.sda.raoul.petclinic.repository.PetRepository;
import com.sda.raoul.petclinic.repository.PetRepositoryImpl;
import com.sda.raoul.petclinic.service.dto.PetDTO;
import com.sda.raoul.petclinic.service.exception.InvalidParameterException;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PetServiceImpl implements PetService {
    private final PetRepository petRepository;
    private final ClientRepository clientRepository;

    public PetServiceImpl() {
        this.petRepository = new PetRepositoryImpl();
        this.clientRepository = new ClientRepositoryImpl();
    }

    @Override
    public void create(String race, Date birthDate, boolean isVaccinated, String ownerFirstName, String ownerLastName) throws InvalidParameterException {
        if (race == null || race.isBlank()) {
            throw new InvalidParameterException("The race is null or blank.");
        }
        if (birthDate == null) {
            throw new InvalidParameterException("The birthDate is null.");
        }
        if (birthDate.after(new Date())) {
            throw new InvalidParameterException("The birthDate is in future.");
        }
        if (ownerFirstName == null || ownerFirstName.isBlank()) {
            throw new InvalidParameterException("The owner's first name is null or blank.");
        }
        if (ownerLastName == null || ownerLastName.isBlank()) {
            throw new InvalidParameterException("The owner's last name is null or blank.");
        }

        Optional<Client> clientResult = clientRepository.findByFirstNameAndLastName(ownerFirstName, ownerLastName);
        if (clientResult.isEmpty()) {
            Client client = new Client(ownerFirstName, ownerLastName, null);
            clientRepository.create(client);
            clientResult = Optional.of(client);
        }
        Pet pet = new Pet(race, birthDate, isVaccinated);
        pet.setOwner(clientResult.get());
        petRepository.create(pet);
    }

    @Override
    public List<Pet> findAllVaccinated() {
        return petRepository.findAllVaccinated();
    }

    @Override
    public List<PetDTO> findAll() {
        return petRepository.findAll()
                .stream().map(pet -> new PetDTO
                        (
                                pet.getId(),
                                pet.getRace(),
                                pet.getBirthDate(),
                                pet.getVaccinated(),
                                pet.getOwner().getFirstName() + " "
                                        + pet.getOwner().getLastName()

                        )).collect(Collectors.toList());
    }

    @Override
    public void deletebyId(Long id) {
        petRepository.deleteById(id);
    }
}
