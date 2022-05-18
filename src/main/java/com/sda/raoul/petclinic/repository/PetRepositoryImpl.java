package com.sda.raoul.petclinic.repository;

import com.sda.raoul.petclinic.model.Pet;
import com.sda.raoul.petclinic.repository.base.BaseRepositoryImpl;

public class PetRepositoryImpl extends BaseRepositoryImpl<Pet, Long> implements PetRepository {
    public PetRepositoryImpl() {
        super(Pet.class);
    }
}
