package com.sda.raoul.petclinic.service;

import com.sda.raoul.petclinic.model.Pet;

import java.util.List;

public interface ClientService {

    List<Pet> findPetsForClientID(Long id);
}
