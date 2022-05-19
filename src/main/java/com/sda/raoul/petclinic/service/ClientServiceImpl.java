package com.sda.raoul.petclinic.service;

import com.sda.raoul.petclinic.model.Client;
import com.sda.raoul.petclinic.model.Pet;
import com.sda.raoul.petclinic.repository.ClientRepository;
import com.sda.raoul.petclinic.repository.ClientRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    public ClientServiceImpl() {
        this.clientRepository = new ClientRepositoryImpl();
    }

    @Override
    public List<Pet> findPetsForClientID(Long id) {
        Optional<Client> client = clientRepository.findByIdAndLoadPets(id);
        if (client.isPresent()) {
            return client.get().getPets();
        }
        return new ArrayList<>();
    }
}
